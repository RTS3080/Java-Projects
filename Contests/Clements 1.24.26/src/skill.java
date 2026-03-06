import java.util.*;
import java.io.*;

public class skill{
    public ArrayList<Integer> buildArray(HashMap<Integer, HashSet<Integer>> adj, HashMap<Integer, Integer> nodeMap, int idx) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<Integer> q = new LinkedList<>();
        q.add(idx);
        while (!q.isEmpty()) {
            int n = q.poll();
            res.add(nodeMap.get(n));
            for (int next : adj.get(n)) {
                q.add(next);
            }
        } return res;
    }

    public int getMedian(ArrayList<Integer> arr) {
        int n = arr.size();
        Collections.sort(arr);
        return arr.get((n - 1) / 2);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("skill".toLowerCase()+".in"));

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> nodeMap = new HashMap<>();

        int n = f.nextInt();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i + 1, f.nextInt());
            adj.put(i + 1, new HashSet<>());
        }

        for (int i = 0; i < n - 1; i++) {
            adj.get(f.nextInt()).add(i + 2);
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = buildArray(adj, nodeMap, i + 1);
            int median = getMedian(arr);
            System.out.println(median);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new skill().run();
    }
}
