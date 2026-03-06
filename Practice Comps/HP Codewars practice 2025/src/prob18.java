import java.util.*;
import java.io.*;

public class prob18{
    int[] shadow;
    int best;
    int[][] adj;
    LinkedList<String> res;

    void dfs(int cur, int b, int cost, String path) {
        if (cost > best || cost > shadow[b] || (b & 1 << cur) > 0)
            return;
//        System.out.printf("%d-%5s-%d-%s%n", cur, Integer.toBinaryString(b), cost, path);
        b |= 1 << cur;
        System.out.println(cur);
        if (b == shadow.length - 1) {
            if (cost < best) {
                res.clear();
                best = cost;
            } res.add(path);
        }

        shadow[b] = cost;
        for (int i = 0; i < adj[cur].length; i++) {
            if (adj[cur][i] == 0) continue;
            dfs(i, b, cost + adj[cur][i],
                    path + " " + Math.min(cur, i) + Math.max(cur, i));
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob18".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            shadow = new int[1 << 5];
            adj = new int[5][5];
            int[][] conns = new int[][]
                    {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {0, 3}, {3, 4}, {0, 4}};
            for (int i = 0; i < 7; i++) {
                adj[conns[i][0]][conns[i][1]]
                        = adj[conns[i][1]][conns[i][0]]
                        = f.nextInt();
            }

            best = Integer.MAX_VALUE;
            res = new LinkedList<>();
            Arrays.fill(shadow, Integer.MAX_VALUE);

            for (int i = 0; i < adj.length; i++) {
                System.out.println(Arrays.toString(adj[i]));
            }
            dfs(0, 0, 0, "");

            LinkedList<String> paths = new LinkedList<>();
            for (String path : res) {
                int x = 1;
                for (int i = 0; i < 7; i++) {
                    path = path.replaceAll(
                                    "" + conns[i][0] + conns[i][1],
                                    "" + x++).trim();
                }

                paths.add(path);
            }

            System.out.println(res);

            Collections.sort(paths);
            System.out.println(paths.poll());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob18().run();
    }
}
