import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Wesley{
    char[][][] mat;
    int[][][] shadow;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Wesley".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r= f.nextInt(), c = f.nextInt();
            mat = new char[5][r][c];
            shadow = new int[5][r][c];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < r; i++) {
                char[] ch = f.next().toCharArray();
                mat[0][i] = ch;
                mat[2][i] = ch.clone();
                mat[4][i] = ch.clone();
                Arrays.fill(mat[1][i], '.');
                for (int j = 0; j < 5; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
                for (int j = 0; j < c; j++) {
                    char cur = ch[j];

                    if(cur == 'S'){
                        sr = i;
                        sc = j;
                        cur = '.';
                    }
                    if(cur == 'E'){
                        er = i;
                        ec = j;
                        cur = '.';
                    }
                    for (int k = 0; k < 5; k+=2) {
                        mat[k][i][j] = cur;
                    }
                    if(Character.isDigit(cur)){
                        int ind = cur-'1';
                        for (int k = 0; k < 5; k+=2) {
                            if(k==ind){
                                mat[k][i][j] = '.';
                            }
                            else{
                                mat[k][i][j] = '#';
                            }
                        }
                    }
                    if(cur=='#' || Character.isDigit(cur)){
                        mat[3][i][j] = '.';
                    }
                    if (cur == '.') {
                        mat[3][i][j] = '#';
                    }
                }
            }
            dfs(sr, sc, 0);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                if(shadow[j][er][ec] < min ){
                    min = shadow[j][er][ec];
                }
            }
            if(min != Integer.MAX_VALUE){
                System.out.println("The Great Escape.");
            }
            else{
                System.out.println("Guess I won't be home in time for dinner.");
            }
        }
        f.close();
    }
    void dfs(int r, int c, int moves){
        int l = moves%5;
        if(r<0 || c<0 || r>=mat[l].length || c>=mat[l][r].length || mat[l][r][c] == '#' || shadow[l][r][c]<=moves){
            return;
        }
        shadow[l][r][c] = moves++;
        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            dfs(r+dr[i],c+dc[i],moves);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Wesley().run();
    }
}
