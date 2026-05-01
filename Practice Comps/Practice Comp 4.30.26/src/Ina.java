import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Ina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ina".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int numComputers = f.nextInt();
            int initial = f.nextInt();
            numTime = f.nextInt();

            HashMap<Integer, Node> nodes = new HashMap<>();
            for (int i = 1; i <= numComputers; i++) nodes.put(i, new Node(-1, i));

            for (int i = 0; i < numComputers-1; i++){
                Node node1 = nodes.get(f.nextInt());
                Node node2 = nodes.get(f.nextInt());
                nodes.get(node1.ind).children.add(node2);
                nodes.get(node2.ind).children.add(node1);
            }

            System.out.printf("Case #%d: %d\n", times, recur(nodes.get(initial), -1));


        }
        f.close();
    }

    int numTime;

    public int recur(Node node, int past){
        if (node.val != -1) return node.val;

        int numExplorable = 0;
        for (Node each : node.children){
            if (each.ind != past) numExplorable++;
        }
        if (numExplorable == 0) return node.val = 0;

        int max = 0;


        int ind = 0;

        for (Node each : node.children){
            if (each.ind == past) continue;
            recur(each, node.ind);
        }

        Collections.sort(node.children);
        for (int i = 0; i < node.children.size(); i++){
            if (node.children.get(i).ind == past) continue;
            int explore = (ind+1) * numTime;
            explore += recur(node.children.get(i), node.ind);
            max = Math.max(max, explore);


            ind++;
        }


        return node.val = max;

    }

    class Node implements Comparable<Node>{
        int val;
        int ind;
        ArrayList<Node> children;
        public Node(int val, int ind){
            this.val = val;
            this.ind = ind;
            children = new ArrayList<>();
        }

        public int compareTo(Node n){
            return n.val - this.val;
        }

        public String toString(){
            String temp = "[val: "+val+", ind: "+ind+" - ";
            for (Node child : children) temp += " "+child.ind;
            return temp+"]";
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Ina().run();
    }
}
