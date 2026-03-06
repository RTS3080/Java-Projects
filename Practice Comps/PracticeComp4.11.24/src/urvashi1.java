import java.util.*;
import java.io.*;

public class urvashi1{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("urvashi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();


        while(times-->0){
            int roads = f.nextInt();
            int k = f.nextInt();
            String start = f.next();
            String end = f.next();
            boolean[][] adj = new boolean[roads][roads];
            Edge[] edges = new Edge[roads];
            Set<String> places = new HashSet<>();
            for(int i = 0; i < roads; i++){
                String st =f.next();
                String en =f.next();
                int cost = f.nextInt();
                places.add(st);
                edges[i] = new Edge(st, en, cost);

            }


        }
        f.close();
    }
    class Edge implements Comparable<Edge>{
        public int cost;
        public String start;
        public String end;
        public Edge(String start, String end,int cost){
            this.cost = cost;
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new urvashi1().run();
    }
}
