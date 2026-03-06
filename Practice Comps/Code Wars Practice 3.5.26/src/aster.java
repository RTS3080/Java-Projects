import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class aster{
    char[][][] mat;
    int[][][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("aster".toLowerCase()+".dat"));
        while(f.hasNext()){
            f.next();
            int n = f.nextInt();
            mat = new char[n][n][n];
            shadow = new int[n][n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = f.next().toCharArray();
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            int sc = f.nextInt(); int sr = f.nextInt(); int sl = f.nextInt();
            int ec = f.nextInt(); int er = f.nextInt(); int el = f.nextInt();
            f.next();
            dfs(sl, sr, sc, 0);

            int end = shadow[el][er][ec];
            System.out.println(end == Integer.MAX_VALUE ? "NO ROUTE" : n+" "+end);
        }
        f.close();
    }
    void dfs(int l, int r, int c, int moves){
        if (l < 0 || r < 0 || c < 0 || l >= mat.length || r >= mat[0].length || c >= mat[0][0].length
                || mat[l][r][c] == 'X' || shadow[l][r][c] <= moves) {

            return;
        }
        shadow[l][r][c] = moves++;
        dfs(l-1, r, c, moves);
        dfs(l+1, r, c, moves);
        dfs(l, r-1, c, moves);
        dfs(l, r+1, c, moves);
        dfs(l, r, c-1, moves);
        dfs(l, r, c+1, moves);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new aster().run();
    }
}
