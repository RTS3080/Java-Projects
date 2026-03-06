import java.util.*;
import java.io.*;

public class navigation{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int r = f.nextInt();
        int c = f.nextInt();
        int sr=-1, sc=-1 , er=-1 , ec= -1;
        mat = new char[r][c];
        shadow = new int[r][c];
        for (int i = 0; i < r; i++) {
            mat[i] = f.next().toCharArray();
            Arrays.fill(shadow[i], Integer.MAX_VALUE);
            for (int j = 0; j < c; j++) {
                if(mat[i][j]=='S'){
                    sr=i;
                    sc=j;
                }
                if(mat[i][j]=='E'){
                    er=i;
                    ec=j;
                }
            }
        }
//        System.out.println(sr+" "+sc+" "+er+" "+ec);
        dfs(sr, sc,0);
        int best = shadow[er][ec];
        System.out.println(best!=Integer.MAX_VALUE?best:"I can't make it. I'm sorry guys!");
        f.close();
    }
    void dfs(int r, int c, int moves){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || mat[r][c]=='#' || shadow[r][c]<=moves){
            return;
        }
        shadow[r][c]=moves;
        int change = 1;
        if(mat[r][c] == 'J'){
            change = 2;
        }
        moves++;
        dfs(r+change, c, moves);
        dfs(r-change, c, moves);
        dfs(r, c+change, moves);
        dfs(r, c-change, moves);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new navigation().run();
    }
}
