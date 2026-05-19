import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class valery{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("valery".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int V = f.nextInt();

        HashMap<String, String[]> adj = new HashMap<>();
        HashMap<String, Integer> deg = new HashMap<>();

        for (int i = 0; i < V; i++) {
            String u = f.next();
            String[] con = new String[f.nextInt()];

            for (int j = 0; j < con.length; j++) {
                con[j] = f.next();
                deg.put(con[j], deg.getOrDefault(con[j], 0) + 1);
            }

            adj.put(u, con);
        }

        PriorityQueue<String> q = new PriorityQueue<>();

        for (String key : adj.keySet()) {
            if (deg.getOrDefault(key, 0) == 0) {
                q.add(key);
            }
        }

        String res = "";

        while (!q.isEmpty()) {
            String cur = q.poll();

            res += "->" + cur;

            for (String next : adj.getOrDefault(cur, new String[0])) {
                int d = deg.put(next, deg.get(next) - 1);

                if (d == 1) q.add(next);
            }
        }

        System.out.println(res.substring(2));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new valery().run();
    }
}
