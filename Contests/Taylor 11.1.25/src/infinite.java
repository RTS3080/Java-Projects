import java.util.*;
import java.io.*;
import java.awt.*;

public class infinite{
    ArrayList<ArrayList<Integer>> results;
    int n;

    public void dfs(double[][] adj, int cur, ArrayList<Integer> vis, double cost) {
        if (vis.size() >= n) return;

        if (vis.contains(cur) && cost > 1) {
            vis.add(cur);
            results.add(new ArrayList<>(vis));
            vis.remove(vis.size() - 1);
            return;
        }

        vis.add(cur);

        for (int i = 0; i < n; i++) {
            if (adj[cur - 1][i] == 0) continue;
            dfs(adj, i + 1, vis, cost * adj[cur - 1][i]);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("infinite".toLowerCase()+".in"));

        while (f.hasNext()){
            n = f.nextInt();
            double[][] adj = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    adj[i][j] = f.nextDouble();
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(adj[i]));
            }

            results = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                dfs(adj, i + 1, new ArrayList<>(), 1);
            }

            System.out.println(results);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new infinite().run();
    }
}
