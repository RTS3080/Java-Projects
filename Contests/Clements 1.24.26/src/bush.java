import java.util.*;
import java.io.*;

public class bush{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("bush".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                int a = f.nextInt();
                int b = f.nextInt();
                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            HashSet<Integer> vis = new HashSet<>();
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            while(!q.isEmpty()){
                int node = q.poll();
                for(Integer i : graph.getOrDefault(node, new ArrayList<>())){
                    if(!vis.contains(i)){
                        vis.add(i);
                        q.offer(i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bush().run();
    }
}
