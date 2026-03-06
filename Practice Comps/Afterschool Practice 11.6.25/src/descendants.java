import java.util.*;
import java.io.*;
import java.awt.*;

public class descendants{
    HashMap<Integer, String> nodes;
    HashMap<Integer, LinkedList<Integer>> adj;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("descendants".toLowerCase()+".dat"));

        nodes = new HashMap<>();
        adj = new HashMap<>();

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String str = f.next();
            int id = f.nextInt();
            int par = f.nextInt();

            adj.putIfAbsent(par, new LinkedList<>());
            adj.get(par).add(id);
            nodes.put(id, str);
        }

        nodes.put(1, "root");

        for (int key : adj.keySet()) {
            adj.get(key).sort((a, b) -> nodes.get(a).compareTo(nodes.get(b)));
        }


        dfs(1, 0);

        f.close();
    }

    public void dfs(int cur, int level) {
        System.out.println("-".repeat(level) + nodes.get(cur));
        for (int next : adj.getOrDefault(cur, new LinkedList<>())) {
            dfs(next, level + 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new descendants().run();
    }
}
