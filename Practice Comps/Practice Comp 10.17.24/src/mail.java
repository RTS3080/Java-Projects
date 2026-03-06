import java.util.*;
import java.io.*;

public class mail{
    int[][] keys;
    int best;
    HashSet<Integer> visited;

    public int dfs(int idx, int steps) {
        best = Math.max(best, steps);
        visited.add(idx);
        int res = 0;
        for (int i = 0; i < keys[idx].length; i++) {
            if (visited.contains(keys[idx][i] - 1)) {
                res += 1;
                continue;
            }
            res += visited.size()+dfs(keys[idx][i] - 1, steps + 1);
        }
        visited.remove(idx);
        return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mail".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int numKeys = f.nextInt();
            keys = new int[numKeys][];
            for (int i = 0; i < keys.length; i++) {
                keys[i] = new int[f.nextInt()];
                for (int j = 0; j < keys[i].length; j++) {
                    keys[i][j] = f.nextInt();
                }
            }

            best = 0;

            int res = 0;
            for (int i = 0; i < keys.length; i++) {
            visited = new HashSet<>();
                res = Math.max(res, dfs(i, 1));
            }

            System.out.println(best);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mail().run();
    }
}
