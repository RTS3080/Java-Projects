import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class isamu{
    class Node {
        int cur, w, b;

        public Node(int cur, int w, int b){
            this.cur = cur;
            this.w = w;
            this.b = b;
        }
    }

    public int bfs(int start, ArrayList<Node>[] adj, int[][] shad) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        q.add(new Node(start, 0, 1 << start));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.cur;
            int w = node.w;
            int b = node.b;

            if (b == shad.length - 1) {
                return w;
            }

            if (w >= shad[b][cur]) continue;

            shad[b][cur] = w;

            for (Node next : adj[cur]) {
                q.add(new Node(next.cur, next.w + w, b | (1 << next.cur)));
            }
        } return -1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("isamu".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int V = f.nextInt(); int E = f.nextInt(); f.nextLine();

            String[] cities = f.nextLine().trim().split(" +");
            String start = cities[0];

            ArrayList<Node>[] adj = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }

            Arrays.sort(cities);

            for (int i = 0; i < E; i++) {
                String a = f.next();
                String b = f.next();

                int w = f.nextInt();
                int ia = Arrays.binarySearch(cities, a);
                int ib = Arrays.binarySearch(cities, b);


                adj[ia].add(new Node(ib, w, 0));
                adj[ib].add(new Node(ia, w, 0));
            }

            int[][] shad = new int[1 << V][V];
            for (int[] row : shad) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            int res = bfs(Arrays.binarySearch(cities, start), adj, shad);

            System.out.println("Case #" + times + ": " + res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new isamu().run();
    }
}
