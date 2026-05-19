import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rhea{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rhea".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r= f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i <r; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == '*'){
                        mat[i][j] = 'R';
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j] == '#'){
                        mat[i][j] = 'V';
                        er = i;
                        ec = j;
                    }
                }
            }
            dfs(sr, sc, 0, 0);

            System.out.println(shadow[er][ec]!=Integer.MAX_VALUE?"yes":"no");
        }
        f.close();
    }
    char[] colors = "ROYGBIV ".toCharArray();
    void dfs(int r, int c, int moves, int colorInd){
        if(r < 0 || c < 0 || r >=mat.length || c >=mat[0].length || shadow[r][c] <=moves
        || colorInd == 7){
            return;
        }
        if(mat[r][c] != colors[colorInd] && mat[r][c] != colors[colorInd+1]){
            return;
        }
        shadow[r][c] = moves++;
        if(mat[r][c] == colors[colorInd+1]){
            colorInd++;
        }
        dfs(r+1, c, moves, colorInd);
        dfs(r-1, c, moves, colorInd);
        dfs(r, c+1, moves, colorInd);
        dfs(r, c-1, moves, colorInd);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new rhea().run();
    }
}
