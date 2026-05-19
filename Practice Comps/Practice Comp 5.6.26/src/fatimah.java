import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class fatimah{
    public int recur(ArrayList<Integer>[] adj, int cur, int bad, int count) {
        int res = count;

        for (int b : adj[cur]) {
            bad |= 1 << b;
        }

        for (int i = cur + 1; i < adj.length; i++) {
            if ((bad & 1 << i) > 0) {
                continue;
            } res = Math.max(res, recur(adj, i, bad, count + 1));
        } return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fatimah".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int V = f.nextInt();
            int E = f.nextInt();

            String[] names = new String[V];

            for (int i = 0; i < V; i++) {
                names[i] = f.next();
            }

            Arrays.sort(names);

            ArrayList<Integer>[] adj = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                String a = f.next();
                String b = f.next();

                int ia = Arrays.binarySearch(names, a);
                int ib = Arrays.binarySearch(names, b);


                adj[ia].add(ib);
                adj[ib].add(ia);
            }

            Arrays.sort(names);

            System.out.println("Case #" + times + ": " + recur(adj, 0, 0, 1));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fatimah().run();
    }
}
