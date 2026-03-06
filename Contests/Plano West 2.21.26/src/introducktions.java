import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class introducktions{
    int[] parent;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("introducktions".toLowerCase()+".in"));

        int N = f.nextInt();

        int maxId = 0;
        for (int i = 0; i < N; i++){
            maxId = Math.max(maxId, f.nextInt());
        }

        DSU dsu = new DSU(maxId);

        int K = f.nextInt();
        for (int i = 0; i < K; i++){
            dsu.join(f.nextInt(), f.nextInt());
        }

        int Q = f.nextInt();
        for (int i = 0; i < Q; i++){
            boolean connected = dsu.check(f.nextInt(), f.nextInt());
            if (connected){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }


        f.close();
    }

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

    public static void main(String[] args) throws FileNotFoundException{
        new introducktions().run();
    }
}
