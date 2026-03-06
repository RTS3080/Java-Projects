import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class manning{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("manning".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            int m = f.nextInt();

            ArrayList<String> nodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                nodes.add(f.next());
            }

            class Edge {
                int u;
                int v;
                double w;

                public Edge(int u, int v, double w){
                    this.u = u;
                    this.v = v;
                    this.w = w;
                }
            }

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                edges[i] = new Edge(nodes.indexOf(f.next()), nodes.indexOf(f.next()), f.nextDouble());
            }

            boolean hasNegCycle = false;
            double[] res = new double[n];

            Arrays.fill(res, 1);

            for (int i = 0; i < n; i++) {
                double[] copy = res.clone();

                for (Edge edge : edges) {
                    int u = edge.u;
                    int v = edge.v;
                    double w = edge.w;

                    if (res[u] * w <= res[v]) continue;

                    if (i == n - 1) hasNegCycle = true;
                    copy[v] = res[u] * w;
                } res = copy;
            }

            System.out.println(hasNegCycle ? "Cha Ching!!" : "gg");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new manning().run();
    }
}
