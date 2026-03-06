import java.util.*;
import java.io.*;

public class sarac{
    HashMap<String, HashSet<String>> con;

    public boolean dfs(String cur, HashSet<String> vis) {
        if (!vis.add(cur)) return true;
        for (String next : con.get(cur)) {
            if (dfs(next, vis)){
                return true;
            }
        } return false;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sarac".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int vert = f.nextInt();
            int d = f.nextInt();
            f.nextLine();
            con = new HashMap<>();
            for (int i = 0; i < vert; i++) {
                con.put(f.next(), new HashSet<>());
            }

            f.nextLine();
            String[] edges = f.nextLine().trim().split(" ");

            for (String ed : edges) {
                String[] edge = ed.split("->");
                con.putIfAbsent(edge[0], new HashSet<>());
                con.get(edge[0]).add(edge[1]);
            }

            boolean flag = false;

            for (String start : con.keySet()) {
                if (dfs(start, new HashSet<>())) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("Deadlock exists; not good...");
            } else {
                System.out.println("Deadlock free; all is well");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sarac().run();
    }
}
