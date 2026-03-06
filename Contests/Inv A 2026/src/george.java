import java.util.*;
import java.io.*;
import java.awt.*;

public class george{
    class Node  implements Comparable<Node>{
        String name;
        int weight;

        public Node(String n, int w) {
            name = n;
            weight = w;
        }

        public int compareTo(Node o) {
            return weight-o.weight;
        }

        public String toString() {
            return name + ":" + weight;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("george".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int edges = f.nextInt();
            int weight = f.nextInt();

            String start = f.next(); String end = f.next();

            HashMap<String, ArrayList<Node>> adj = new HashMap<>();

            for (int i = 0; i < edges; i++) {
                String a = f.next();
                String b = f.next();
                int w = f.nextInt();
                int limit = f.nextInt();
                if (limit < weight) continue;

                adj.putIfAbsent(a, new ArrayList<>());
                adj.putIfAbsent(b, new ArrayList<>());
                adj.get(a).add(new Node(b, w));
                adj.get(b).add(new Node(a, w));
            }

//            for (String s : adj.keySet()) {
//                System.out.println(s + ": " + adj.get(s));
//            }

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(start, 0));
            HashSet<String> vis = new HashSet<>();

            int res = -1;

            while (!q.isEmpty()) {
                Node node = q.poll();
                String n = node.name;
                int w = node.weight;

//                System.out.println(node);

                if (n.equals(end)) {
                    res = w;
                    break;
                }

                if (!vis.add(n)) {
                    continue;
                }

                for (Node next : adj.getOrDefault(n, new ArrayList<>())) {
                    q.add(new Node(next.name, next.weight + w));
                }
            }

            if (res == -1) {
                System.out.println("No route possible");
            } else {
                System.out.println("Shortest distance: " + res);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new george().run();
    }
}
