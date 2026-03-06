import java.util.*;
import java.io.*;
import java.awt.*;

public class ordering{
    ArrayList<String[]> results;
    HashMap<Integer, HashSet<Integer>> adj;
    int[] in;

    public void dfs(int cur, String path, LinkedList<Integer> next, int found) {
        if (found == 0) {
            results.add(path.trim().split(" "));
            return;
        }

        for (int n : adj.getOrDefault(cur, new HashSet<>())) {
            in[n - 1]--;
            if (in[n - 1] == 0) {
                next.add(n);
            }
        }

        LinkedList<Integer> copy = new LinkedList<>(next);

        for (int n : next) {
            copy.remove((Integer) n);
            dfs(n, path + " " + n, copy, found - 1);
            copy.add(n);
        }

        next = copy;

        for (int n : adj.getOrDefault(cur, new HashSet<>())) {
            in[n - 1]++;
            if (next.contains(n))
                next.add(n);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ordering".toLowerCase()+".in"));

        adj = new HashMap<>();
        results = new ArrayList<>();
        int houses = f.nextInt();
        int edges = f.nextInt();
        in = new int[houses];

        for (int i = 0; i < edges; i++) {
            int a = f.nextInt();
            int b = f.nextInt();

            in[b - 1]++;
            adj.putIfAbsent(a, new HashSet<>());
            adj.get(a).add(b);
        }

        f.nextLine();

        String check = f.nextLine().trim();
        LinkedList<Integer> next = new LinkedList<>();
        for (int i = 0; i < houses; i++) {
            if (in[i] == 0) {
                next.add(i + 1);
            }
        }

        dfs(0, "", next, houses);

        Collections.sort(results, (a, b) -> {
            return compare(a, b);
        });

        int idx = 0;
        for (int i = 0; i < results.size(); i++) {
            if (compare(results.get(i), check.trim().split(" ")) > 0) {
                idx = i;
                break;
            }
        }

        String res = "";
        String[] strs = results.get(idx);
        for (String str : strs) {
            res += str + " ";
        }
        System.out.println(res.trim());

        f.close();
    }

    public int compare(String[] x, String[] y) {
        int[] a = new int[x.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(x[i]);
        }

        int[] b = new int[y.length];
        for (int j = 0; j < y.length; j++) {
            b[j] = Integer.parseInt(y[j]);
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        } return 0;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new ordering().run();
    }
}
