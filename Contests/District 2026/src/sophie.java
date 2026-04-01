import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sophie{
    class DSU {
        int[] cities;
        public DSU(int N) {
            cities = new int[N];

            for (int i = 0; i < N; i++) {
                cities[i] = i;
            }
        }

        public int find(int n) {
            if (n == cities[n]) return n;
            return cities[n] = find(cities[n]);
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public void join(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            cities[fa] = fb;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sophie".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int colors = f.nextInt();
            int numCities = f.nextInt();
            int numEdges = f.nextInt();
            int numQueries = f.nextInt();

            HashMap<String, Integer> colorMap = new HashMap<>();
            HashMap<String, Integer> cityMap = new HashMap<>();

            for (int i = 0; i < colors; i++) {
                colorMap.put(f.next(), i);
            }

            for (int i = 0; i < numCities; i++) {
                cityMap.put(f.next(), i);
            }

            DSU[] dsus = new DSU[colors];

            for (int i = 0; i < colors; i++) {
                dsus[i] = new DSU(numCities);
            }

            for (int i = 0; i < numEdges; i++) {
                int c1 = cityMap.get(f.next());
                int c2 = cityMap.get(f.next());
                int color = colorMap.get(f.next());
                DSU dsu = dsus[color];

                dsu.join(c1, c2);
            }

            for (int i = 0; i < numQueries; i++) {
                int c1 = cityMap.get(f.next());
                int c2 = cityMap.get(f.next());
                int color = colorMap.get(f.next());
                DSU dsu = dsus[color];

                if (dsu.isConnected(c1, c2)) {
                    System.out.println("Route Completed");
                } else {
                    System.out.println("Route Not Completed");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sophie().run();
    }
}
