import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class roadside{
    class Node {
        int b, n, w;

        public Node(int b, int n, int w) {
            this.b = b;
            this.n = n;
            this.w = w;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("roadside".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();

            int[][] shad = new int[1 << n][n];
            int[][] adj = new int[n][n];

            for (int[] row : shad) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = f.nextInt();
                }
            }

            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 0));

            while (!q.isEmpty()) {
                Node node = q.poll();
                int b = node.b;
                int cur = node.n;
                int w = node.w;

                if (w >= shad[b][cur]) continue;
                shad[b][cur] = w;

                b |= 1 << cur;

                if (w >= shad[b][cur]) continue;
                shad[b][cur] = w;

                for (int next = 0; next < n; next++) {
                    if (adj[cur][next] <= 0) continue;
                    q.add(new Node(b, next, w + adj[cur][next]));
                }
            }

            int res = Integer.MAX_VALUE;
            for (int cur = 0; cur < shad[shad.length - 1].length; cur++) {
                int weight = shad[shad.length - 1][cur];
                if (weight == Integer.MAX_VALUE) continue;

                q = new LinkedList<>();
                q.add(new Node(0, cur, weight));

                int[] vis = new int[n];
                Arrays.fill(vis, Integer.MAX_VALUE);

                while (!q.isEmpty()) {
                    Node node = q.poll();
                    if (vis[node.n] <= node.w) {
                        continue;
                    }

                    vis[node.n] = node.w;

                    for (int i = 0; i < n; i++) {
                        if (adj[node.n][i] > 0) {
                            q.add(new Node(0, i, adj[node.n][i] + node.w));
                        }
                    }
                }

                res = Math.min(res, vis[0]);
            }

            System.out.println(res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new roadside().run();
    }
}
