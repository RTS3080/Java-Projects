import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class urvashi{
    int K;

    public int rev(int n) {
        return Integer.parseInt(new StringBuilder("" + n).reverse().toString());
    }

    class Node {
        String node;
        int[] weights;

        public Node(String s, int weight) {
            node = s;
            weights = new int[3];
            weights[0] = weight;
            weights[2] = rev(weights[1] = rev(weight));
        }

        public String toString() {
            return node + " " + Arrays.toString(weights);
        }
    }

    public long dfs(HashMap<String, ArrayList<Node>> adj, String cur, String end, long steps, int k, HashMap<String, long[]> vis) {
        if (cur.equals(end)) return steps;

        if (vis.get(cur) == null) {
            vis.put(cur, new long[K]);
            Arrays.fill(vis.get(cur), Long.MAX_VALUE/16);
        }

        if (vis.get(cur)[k] <= steps)
            return Long.MAX_VALUE / 16;

        vis.get(cur)[k] = steps;

        long res = Long.MAX_VALUE / 16;

        for (int i = 0; i < Math.min(3, k + 1); i++) {
            for (Node node : adj.getOrDefault(cur, new ArrayList<>())) {
                String next = node.node;
                int w = node.weights[k];

                res = Math.min(res, dfs(adj, next, end, steps + w, k - i, vis));
            }
        }

        return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("urvashi".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            HashMap<String, ArrayList<Node>> adj = new HashMap<>();
            HashMap<String, long[]> vis = new HashMap<>();

            int M = f.nextInt();
            int K = f.nextInt();
            String start = f.next();
            String end = f.next();

            for (int i = 0; i < M; i++) {
                String a = f.next();
                String b = f.next();
                int w = f.nextInt();

                Node na = new Node(a, w);
                Node nb = new Node(b, w);

                adj.putIfAbsent(a, new ArrayList<>());
                adj.putIfAbsent(b, new ArrayList<>());
                vis.putIfAbsent(a, new long[K + 1]);
                vis.putIfAbsent(b, new long[K + 1]);

                Arrays.fill(vis.get(a), Long.MAX_VALUE / 16);
                Arrays.fill(vis.get(b), Long.MAX_VALUE / 16);

                adj.get(a).add(nb);
                adj.get(b).add(na);
            }

            long res = dfs(adj, start, end, 0, K, vis);

            if (res >= Long.MAX_VALUE / 32) {
                System.out.println("Case #" + (times + 1) + ": IMPOSSIBLE");
            } else System.out.println("Case #" + (times + 1) + ": " + res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new urvashi().run();
    }
}
