import java.util.*;
import java.io.*;

public class finding {
    public static void main(String[] args) throws FileNotFoundException {
        new finding().run();
    }

    public class Node implements Comparable<Node> {
        int c;
        int weight;

        public Node (int c, int w) {
            this.c = c;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public void run () throws FileNotFoundException {
        Scanner f = new Scanner(new File("finding.dat"));

        int T = f.nextInt();

        while (T-- > 0) {
            int N = f.nextInt(), M = f.nextInt(), K = f.nextInt();

            int[] times = new int[N+2];

            for (int i = 0; i < N; i++) {
                times[i+1] = f.nextInt();
            }

            boolean[] v = new boolean[N+2];
            boolean[][] g = new boolean[N+2][N+2];

            for (int i = 0; i < M; i++) {
                int a = f.nextInt(), b = f.nextInt();

                g[a][b] = true; g[b][a] = true;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, K));

            while (!pq.isEmpty()) {
                Node c = pq.poll();

                if (c.c == N+1) {
                    System.out.println(c.weight);
                    break;
                }

                if (v[c.c])
                    continue;
                v[c.c] = true;

                for (int i = 0; i < N+2; i++) {
                    if (g[c.c][i]) {
                        pq.add(new Node(i, c.weight+times[i]));
                    }
                }
            }
        }

        f.close();
    }
}