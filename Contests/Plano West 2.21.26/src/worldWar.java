import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class worldWar{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("worldWar".toLowerCase()+".in"));
        int r = f.nextInt();
        int c = f.nextInt();
        mat = new char[r][c];
        shadow = new int[r][c];
        int sr = -1, sc = -1, er = -1, ec = -1;
        for (int i = 0; i < r; i++) {
            Arrays.fill(shadow[i], Integer.MAX_VALUE);
            mat[i] = f.next().toCharArray();
            for (int j = 0; j < c; j++) {
                if(mat[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                if(mat[i][j] == 'E'){
                    er = i;
                    ec = j;
                }
            }
        }
        dfs(sr, sc, 0);
        int min = shadow[er][ec];
        System.out.println(min != Integer.MAX_VALUE ? min : -1);

        f.close();
    }
    void dfs(int r, int c, int moves){
        if(r < 0 || r>=mat.length | c<0 || c>=mat[0].length || mat[r][c] == 'X' || shadow[r][c] <= moves){
            return;
        }
        shadow[r][c] = moves++;
        dfs(r+1, c, moves);
        dfs(r-1, c, moves);
        dfs(r, c+1, moves);
        dfs(r, c-1, moves);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new worldWar().run();
    }
}
