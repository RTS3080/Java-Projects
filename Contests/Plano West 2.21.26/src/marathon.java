import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class marathon{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("marathon".toLowerCase()+".in"));

        int N = f.nextInt();

        PriorityQueue<Integer> storage = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            storage.add(i + 1);
        }

        int[] deg = new int[N + 1]; deg[0] = -1;

        Stack<Integer> path = new Stack<>();

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();

        int M = f.nextInt();

        for (int i = 0; i < M; i++) {
            int a = f.nextInt();
            int b = f.nextInt();
            adj.putIfAbsent(b, new HashSet<>());
            adj.get(b).add(a);

            deg[a]++;

            storage.remove(a);
            storage.remove(b);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0 && !storage.contains(i)) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            while (!storage.isEmpty() && storage.peek() < cur) {
                path.push(storage.poll());
            } path.push(cur);

            for (int next : adj.getOrDefault(cur, new HashSet<>())) {
                deg[next]--;

                if (deg[next] == 0) {
                    q.add(next);
                }
            }
        }

        while (!storage.isEmpty()) {
            path.push(storage.poll());
        }

        String out = "";
        while (!path.isEmpty()) {
            out += path.pop() + " ";
        }
        System.out.println(out.trim());

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new marathon().run();
    }
}
