import java.util.*;
import java.io.*;
import java.awt.*;

public class rhea{
    String rainbow = "ROYGBIV";
    char[][] mat;

    public boolean dfs(int prev, int r, int c, int er, int ec) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) return false;

        if (mat[r][c] == '-') return false;
        int idx = rainbow.indexOf(mat[r][c]);
        if (idx - prev != 0 && idx - prev != 1 && idx - prev != -1) return false;
        if (r == er && c == ec) return true;

        mat[r][c] = '-';
        boolean res = false;
        res |= dfs(idx, r - 1, c, er, ec);
        res |= dfs(idx, r + 1, c, er, ec);
        res |= dfs(idx, r, c - 1, er, ec);
        res |= dfs(idx, r, c + 1, er, ec);
        return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rhea".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();

            mat = new char[rows][cols];
            int sr = -1, sc = -1;
            int er = -1;
            int ec = -1;

            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == '*') {
                        sr = i;
                        sc = j;
                    }
                    if (mat[i][j] == '#') {
                        er = i;
                        ec = j;
                    }
                }
            }

            mat[sr][sc] = 'R';
            mat[er][ec] = 'V';

            boolean res = dfs(0, sr, sc, er, ec);
            System.out.println(res ? "yes" : "no");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rhea().run();
    }
}
