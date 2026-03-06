import java.util.*;
import java.io.*;

public class connected_Ryder{

    //THIS SOLUTION IS COMPLETELY OVERKILL, I MISREAD THE PROBLEM
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("connected".toLowerCase()+".dat"));
        HashMap<String, TreeSet<String>> links = new HashMap<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            links.putIfAbsent(ln[0], new TreeSet<>());
            links.putIfAbsent(ln[1], new TreeSet<>());

            links.get(ln[1]).add(ln[0]);
            links.get(ln[0]).add(ln[1]);


        }
        Queue<Node> q = new LinkedList<>();
        TreeSet<String> visited = new TreeSet<>();
        q.add(new Node("Pratahamesh",0));
        while(!q.isEmpty()){
            Node n = q.poll();
            String str = n.str;
            int moves = n.moves;

            if(visited.contains(str)){
                continue;
            }
            visited.add(str);
            for(String s : links.get(str)){
                q.add(new Node(s,moves+1));
            }
        }
        visited.remove("Pratahamesh");
        System.out.println("--Interrogation List--");
        for(String s : visited){
            System.out.println(s);
        }
        f.close();
    }

    class Node{
        String str;
        int moves;
        public Node(String str, int moves){
            this.str = str;
            this.moves = moves;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new connected_Ryder().run();
    }
}
