import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ferret{
    char[][][] mat;
    int[][][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ferret".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        while(f.hasNext()){
            f.next();
            int c = f.nextInt();
            int r = f.nextInt();
//            System.out.println(r+" "+c);
            mat = new char[4][r][c];
            shadow = new int[4][r][c];
            ArrayList<int[]> lasers = new ArrayList<>();
            int sr = -1, sc = -1;
            for (int i = 0; i < r; i++) {
                mat[0][i] = f.next().toCharArray();
//                System.out.println(mat[0][i]);
                for (int j = 1; j < 4; j++) {
                    System.arraycopy(mat[0][i], 0, mat[j][i], 0, c);
                }
                for (int j = 0; j < 4; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
                for (int j = 0; j < c; j++) {
                    if(mat[0][i][j] == 'L'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[0][i][j] == 'S'){
                        lasers.add(new int[]{i,j});
                    }
                }
            }
            f.next();
            int[][] laserDirs= {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
            for(int[] laser : lasers){
                for (int k = 0; k < 4; k++) {
                    int i = laser[0];
                    int j = laser[1];
                    while(i>=0 && j>=0 && i<r && j<c){
                        mat[k][i][j] = 'P';
                        i+=laserDirs[k][0];
                        j+=laserDirs[k][1];
                    }
                }
            }

            bmoves = Integer.MAX_VALUE;
            dfs(sr, sc, 0);

//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < r; j++) {
//                    System.out.println(mat[i][j]);
//                }
//                System.out.println();
//            }
//
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < r; j++) {
//                    System.out.println(Arrays.toString(shadow[i][j]));
//                }
//                System.out.println();
//            }
//            System.out.println();
            System.out.println(bmoves == Integer.MAX_VALUE?"GARRET":"FERRET");


        }
        f.close();
    }
    int bmoves;
    void dfs(int r, int c, int moves){
        int l = moves %4;
        if(r < 0 || c<0 || r>= mat[0].length || c>= mat[l][r].length || mat[l][r][c] == 'P' || bmoves <= moves || shadow[l][r][c] <=moves){
            return;
        }
//        int prevL = (l+3)%4;
//        if(mat[prevL][r][c] == 'P'){
//            return;
//        }
        if(mat[l][r][c] == 'G'){
            bmoves = moves;
        }
        shadow[l][r][c] = moves++;
        dfs(r+1, c, moves);
        dfs(r+1, c+1, moves);
        dfs(r+1, c-1, moves);


    }


    public static void main(String[] args) throws FileNotFoundException{
        new ferret().run();
    }
}
