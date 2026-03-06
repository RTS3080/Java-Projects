import java.util.*;
import java.io.*;
import java.awt.*;
import java.math.*;

public class Trash{
    char[][][] mat;
    int[][][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
//        Scanner f = new Scanner(new File("trashTesting.dat"));
        Scanner f = new Scanner(new File("Judge Data\\trash.dat"));
        int times=f.nextInt();
        while(times-->0){
            int r = f.nextInt();
            int c = r;
            int t= f.nextInt(); f.nextLine();
            mat = new char[4][r][c];
            shadow = new int[12][r][c];
            int startR = -1;
            int startC = -1;
            bmoves = Integer.MAX_VALUE;
            ArrayList<int[]> monsters = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < r; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < r; i++) {
                char[] ln = f.next().toCharArray();
                mat[0][i] = ln;
                for (int j = 0; j < c; j++) {
                    if(mat[0][i][j] == 'S'){
                        startR = i;
                        startC = j;
                    }
                    if(mat[0][i][j] == 'M'){
                        monsters.add(new int[]{i,j});
                    }
                }
            }
            //setting up Dianoga Monsters
            for(int[] monster : monsters){
                for (int l = 0; l < 4; l++) {
                    for (int i = Math.max(0, monster[0] - 1); i <= monster[0] + 1 && i <= mat[0].length - 1; i++) {
                        for (int j = Math.max(0, monster[1] - 1); j <= monster[1] + 1 && j <= mat[1].length - 1; j++) {
                            mat[l][i][j] = '#';
                        }
                    }
                }
            }

            //pre-rotate the maze
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        mat[i][k][j] = mat[i-1][r-1-j][k];
                    }
                }
            }


            dfs(startR, startC, 0);


            System.out.println(bmoves <= t?"Shut down all garbage mashers on the Detention Level, will you?"
                    :bmoves == Integer.MAX_VALUE?"Listen to them! They're dying R2!":"Don't take so long Han.");


        }
        f.close();
    }
    void dfs(int r, int c, int moves){
        int l = moves%12; //used for the level of shadow
        int m = (moves/3)%4; //used for level of maze

        //check if out of bounds, in wall, or have already visited at a faster pace
        if(r<0 || r>=mat[m].length || c<0 || c>=mat[m][r].length || mat[m][r][c] =='#' ||
            shadow[l][r][c] <=moves){
            return;
        }

        //check if you moved into a wall before rotation
        if(moves%3==0&&moves!=0){
            if(mat[(moves/3 -1)%4][r][c]=='#'){
            // use (moves/3-1)%4 to shift to the previous rotation layer
                // so that you can check if you moved into a wall before rotation
                return;
            }
        }

        shadow[l][r][c] = moves;
        if(mat[m][r][c] == 'E'){
            bmoves = Math.min(bmoves, moves);
        }
        moves++;
        dfs(r,c+1,moves);
        dfs(r,c-1,moves);
        dfs(r+1,c,moves);
        dfs(r-1,c,moves);
        dfs(r,c,moves);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Trash().run();
    }
}
