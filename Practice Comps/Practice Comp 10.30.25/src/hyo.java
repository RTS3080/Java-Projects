import java.util.*;
import java.io.*;
import java.awt.*;

public class hyo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hyo".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<String, ArrayList<String>> graph = new HashMap<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String[] ln = f.nextLine().split(": ?");
                graph.putIfAbsent(ln[0], new ArrayList<>());
                String[] friends = ln[1].split(" ");
                for(String friend : friends){
                    graph.get(ln[0]).add(friend);
                }
            }
            System.out.println(graph);
            String start = f.next();
            String end = f.next();
            int minTime = Integer.MAX_VALUE;
            HashSet<String> vis = new HashSet<>();
            Queue<Object[]> q = new LinkedList<>();
            Queue<String> s = new LinkedList<>();
            s.add(start);
            q.offer(new Object[]{start,0, s});
            Queue<String> order = new LinkedList<>();
            while(!q.isEmpty()){
                Object[] cur = q.poll();
                String node = (String)cur[0];
                Queue<String> prev = (LinkedList<String>)cur[2];
                int t = (int)cur[1];
                if(t>=minTime) continue;
                if(node.equals(end)){
                    minTime=t;
                    order = prev;
                }
                for(String friend : graph.get(node)){
                    if(vis.contains(friend)){
                        continue;
                    }
                    vis.add(friend);
                    Queue<String> p = new LinkedList<>(prev);
                    p.add(friend);
                    q.offer(new Object[]{friend,t+1, p});
                }
            }
            System.out.println("The degree of separation between "+start+" and "+end+" is "+minTime+".");
            String out = "";
            for(String str : order){
                out+=str+" is a friend of ";
            }
            System.out.println(out.substring(0,out.length()-16)+".");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hyo().run();
    }
}
