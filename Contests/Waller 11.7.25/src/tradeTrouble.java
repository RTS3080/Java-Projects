import java.util.*;
import java.io.*;
import java.awt.*;

public class tradeTrouble{
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tradeTrouble".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<String, ArrayList<Node>> graph = new HashMap<>();
            f.nextInt();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String start = f.next();
                String end = f.next();
                int cost = f.nextInt();

                graph.putIfAbsent(start, new ArrayList<>());
                graph.get(start).add(new Node(end, cost));
                graph.putIfAbsent(end, new ArrayList<>());
            }

            String start = f.next();
            String end = f.next();
            PriorityQueue<Node> q = new PriorityQueue<>();
            HashMap<String, Integer> shad = new HashMap<>();
            q.add(new Node(start, 0));

            int res = -1;
            while (!q.isEmpty()){
                Node node = q.poll();
                String cur = node.name;
                int cost = node.cost;

                if (cur.equals(end)) {
                    res = cost;
                    break;
                }

                if (shad.containsKey(cur)){
                    if (cost >= shad.get(cur)) {
                        continue;
                    }
                }
                shad.put(cur, cost);
                System.out.println(cur);

                for (Node next : graph.getOrDefault(cur, new ArrayList<>())) {
                    q.add(new Node(next.name, cost + next.cost));
                }
            }

            if (res == -1){
                System.out.println("Uh Oh, Trading Trouble");
            } else {
                System.out.println(res);
            }
        }
        f.close();
    }
    class Node implements Comparable<Node>{
        String name;
        int cost;

        public Node(String name, int cost){
            this.name=name;
            this.cost=cost;
        }
        public int compareTo(Node n){
            return cost-n.cost;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tradeTrouble().run();
    }
}
