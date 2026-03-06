import java.util.*;
import java.io.*;

public class sergio{

    public void run() throws FileNotFoundException{
        Scanner in = new Scanner(new File("sergio".toLowerCase()+".dat"));
        int times = in.nextInt();
        for (int i = 0; i < times; i++) {
            int v = in.nextInt();
            int e = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int j = 0; j < v; j++) {
                adj.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                int node = in.nextInt();
                int connect = in.nextInt();
                adj.get(node).add(connect);
            }
            boolean cycle = false;
            for (int j = 0; j < v; j++) {
                if(DFS(j, adj, new HashSet<>())){
                    cycle = true;
                    break;
                }
            }
            if(cycle){
                System.out.println("Cycle");
            }
            else{
                System.out.println("No cycle");
            }
        }
        in.close();
    }
    public boolean DFS(int curr, ArrayList<ArrayList<Integer>> gr, HashSet<Integer> vis){
        if(vis.contains(curr)) return true;
        vis.add(curr);
        for(int node: gr.get(curr)){
            if(DFS(node,gr,vis)){
                return true;
            }
        }
        vis.remove(curr);
        return false;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sergio().run();
    }
}

