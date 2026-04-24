import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jade{
    class DSU {
        int[] par;

        public DSU(int n) {
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        public int find(int n) {
            if (n == par[n]) return n;
            return par[n] = find(par[n]);
        }

        public boolean check() {
            for (int i = 0; i < par.length; i++) {
                if (find(i) != find(0)) return false;
            } return true;
        }

        public void join(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            par[fa] = fb;
        }
    }

    class Node {
        int cur, w, d;
        HashSet<Integer> path;

        public Node(int cur, int w, int d, HashSet<Integer> path) {
            this.cur = cur;
            this.w = w;
            this.d = d;
            this.path = path;
        }
    }

    public int travel(HashMap<Integer, LinkedList<Node>> adj, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        q.add(new Node(start, 0, 1, new HashSet<>()));

        int[] vis = new int[adj.size()];

        Arrays.fill(vis, Integer.MAX_VALUE);


        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.cur;
            int w = node.w;
            int d = node.d;
            HashSet<Integer> path = node.path;

//            if (w >= vis[cur]) continue;

//            System.out.println(cur + " " + w + " " + d);

            path.add(cur);

            if (path.size() == vis.length) return w;

            for (Node next : adj.getOrDefault(cur, new LinkedList<>())) {
                q.add(new Node(next.cur, next.w + w, d + 1, new HashSet<>(path)));
            }
        } return -1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jade".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int M = f.nextInt();

            DSU dsu = new DSU(N);

            HashMap<Integer, LinkedList<Node>> adj = new HashMap<>();

            for (int i = 0; i < M; i++) {
                int a = f.nextInt();
                int b = f.nextInt();
                int w = f.nextInt();

                dsu.join(a, b);

                adj.putIfAbsent(a, new LinkedList<>());
                adj.putIfAbsent(b, new LinkedList<>());
                adj.get(a).push(new Node(b, w, 0, new HashSet<>()));
                adj.get(b).add(new Node(a, w, 0, new HashSet<>()));
            }

            if (!dsu.check()) {
                System.out.println("I'm going to Jade's house.");
                continue;
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                res = Math.min(res,
                        travel(adj, i));
            }

            System.out.println(res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jade().run();
    }
}
