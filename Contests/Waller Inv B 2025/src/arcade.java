import java.util.*;
import java.io.*;

public class arcade{
    char[][][] mat;
    int[][][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("arcade".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r,c,life;
            r = f.nextInt();
            c = f.nextInt();
            life = f.nextInt();
            mat = new char[4][r][c];
            shadow = new int[4][r][c];
            bmoves = Integer.MAX_VALUE;
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < r; i++) {
                char[] chs = f.next().toCharArray();
                for (int j = 0; j < 4; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
                for (int j = 0; j < chs.length; j++) {
                    mat[0][i][j] = chs[j];
                    mat[2][r-1-i][c-1-j] = chs[j];
                    if(mat[0][i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[0][i][j] == 'E'){
                        er = i;
                        ec = j;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[3][i][j] = mat[0][j][r-1-i];
                    mat[1][i][j] = mat[2][j][r-1-i];
                }
            }


            recur(sr,sc,0);

            if(bmoves <= life){
                System.out.println("Escaped the Arcade in "+bmoves+" steps.");
            }
            else System.out.println("Total Knockout.");
        }
        f.close();
    }
    void recur(int r, int c ,int moves){
        if(r<0 || c<0 || r>=mat[0].length  || c>=mat[0].length || shadow[moves%4][r][c] <= moves){
            return;
        }
        shadow[moves%4][r][c] = moves;
        if(mat[moves%4][r][c] =='E'){
            bmoves = Math.min(bmoves,moves);
        }
        if(mat[moves%4][r][c] == 'J'){
            recur(r,c,moves+1);
        }
        else{
            recur(r+1,c,moves+1);
            recur(r,c+1,moves+1);
            recur(r-1,c,moves+1);
            recur(r,c-1,moves+1);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new arcade().run();
    }
}
