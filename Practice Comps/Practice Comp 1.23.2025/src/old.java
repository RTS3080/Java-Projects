import java.util.*;
import java.io.*;

public class old{
    char[][] mat;
    int[][][] shadow;
    int best;
    char[] people;

    public void dfs(int r, int c, int steps, int b) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || mat[r][c] == '#' || steps >= shadow[b][r][c]) return;
        shadow[b][r][c] = steps;
        if (mat[r][c] == 'A' + b) {
            b++;
        }

        if (mat[r][c] == '?' && b == shadow.length - 1) {
            best = Math.min(steps, best);
        }
        steps++;
        if (mat[r][c] == '@') steps++;

        dfs(r - 1, c, steps, b);
        dfs(r + 1, c, steps, b);
        dfs(r, c - 1, steps, b);
        dfs(r, c + 1, steps, b);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("old".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            int maxS = f.nextInt(); int old = f.nextInt();

            mat = new char[rows][cols];
            shadow = new int[old + 1][rows][cols];
            int sr = -1;
            int sc = -1;
            int er = -1;
            int ec = -1;
            f.nextLine();
            int c = 0;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == '?') {
                        sr = i;
                        sc = j;
                    }
                }
            }




            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'A'+old-1) {
                        er = i;
                        ec = j;
                    }
                }
            }

            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }

            dfs(sr, sc, 0, 0);

            best = shadow[old][sr][sc];
//            System.out.println(best);
            if (best <= maxS) {
                System.out.println("Olds Collected.");
            } else {
                System.out.println("Time Runs Out.");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new old().run();
    }
}
