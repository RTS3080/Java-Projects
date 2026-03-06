import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class duckwar{
    class DSU {
        int[] par;
        public DSU(int n) {
            par = new int[n + 1];
            for (int i = 0; i < par.length; i++) {
                par[i] = i;
            }
        }

        public int find(int n) {
            if (n == par[n]) return n;
            return par[n] = find(par[n]);
        }

        public boolean check(int a, int b) {
            return find(a) == find(b);
        }

        public void join(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            par[fa] = fb;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("duckwar".toLowerCase()+".in"));

        int N = f.nextInt();
        int Q = f.nextInt();

        DSU dsu = new DSU(N);

        while (Q-- > 0) {
            String op = f.next();

            if (op.equals("SIZE")) {
                int n = f.nextInt();
                int fn = dsu.find(n);
                int size = 0;

                for (int i = 0; i < dsu.par.length; i++) {
                    if (dsu.find(i) == fn) size++;
                }

                System.out.println(size);
            } else if (op.equals("ALLY")) {
                dsu.join(f.nextInt(), f.nextInt());
            } else {
                System.out.println(dsu.check(f.nextInt(), f.nextInt()) ? "QUACK" : "SPLASH");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new duckwar().run();
    }
}
