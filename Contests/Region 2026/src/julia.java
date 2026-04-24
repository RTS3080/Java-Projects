import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class julia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("julia".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int V = f.nextInt();
            int E = f.nextInt();

            HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();

            int[] degrees = new int[V];

            for (int i = 0; i < E; i++) {
                int a = f.nextInt();
                int b = f.nextInt();

                adj.putIfAbsent(a, new HashSet<>());
                adj.get(a).add(b);

                degrees[b]++;
            }

            LinkedList<Integer> q = new LinkedList<>();

            for (int i = 0; i < V; i++) {
                if (degrees[i] == 0) {
                    q.add(i);
                }
            }

            int vis = 0;

            while (!q.isEmpty()) {
                int u = q.poll();

                vis++;

                for (int v : adj.getOrDefault(u, new HashSet<>())) {
                    if (--degrees[v] == 0) {
                        q.add(v);
                    }
                }
            }

            if (vis == V) {
                System.out.println("Juliain't gonna beat me.");
            } else {
                System.out.println("Lizn't that interesting.");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new julia().run();
    }
}
