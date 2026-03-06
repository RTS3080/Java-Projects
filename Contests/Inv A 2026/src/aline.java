import java.util.*;
import java.io.*;
import java.awt.*;

public class aline{
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("aline".toLowerCase()+".dat"));
        int vertices = f.nextInt();
        String ln = f.next();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < vertices; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < vertices-1; i++) {
            int start = f.nextInt();
            int end = f.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        ArrayList<String> possibilities = new ArrayList<>();
        int duplicates = 0;
        for (int i = 0; i < vertices; i++) {
            HashSet<Integer> vis = new HashSet<>();
            Queue<Object[]> q = new LinkedList<>();
            q.offer(new Object[]{i, ""});
            vis.add(i);
            while (!q.isEmpty()) {
                Object[] arr = q.poll();
                int node = (int) arr[0];
                String until = (String) arr[1];
                possibilities.add(until + ln.charAt(node) + "");
                for (int j : graph.get(node)) {
                    if (!vis.contains(j)) {
                        vis.add(j);
                        q.add(new Object[]{j, until + ln.charAt(node) + ""});
                    }
                }
            }
        }
        for (int i = 0; i < possibilities.size(); i++) {
            for (int j = 0; j < possibilities.size(); j++) {
                if (i == j) continue;
                if (possibilities.get(i).equals(possibilities.get(j))) duplicates++;
            }
        }
        System.out.println(possibilities.size()-duplicates);




        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new aline().run();
    }
}
