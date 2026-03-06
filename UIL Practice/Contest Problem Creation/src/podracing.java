import java.util.*;
import java.io.*;
import java.awt.*;

public class podracing{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("podracing".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int min = f.nextInt(); int max = f.nextInt();
            int r = f.nextInt(); int c = f.nextInt(); f.nextLine();
            mat = new char[r][c];
            shadow = new int[r][c];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for(int i=0; i<r; i++){
                mat[i] = f.next().toCharArray();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                    else if(mat[i][j] == 'E') {
                        er = i;
                        ec = j;
                    }
                }
            }
            dfs(sr, sc, 0);
            int bmoves = shadow[er][ec];
            if(bmoves <= min){
                System.out.println("Eat my exhausts!");
            }
            else if(bmoves > max){
                System.out.println("You must have Jedi reflexes.");
            }
            else{
                System.out.println("Now this is podracing!");
            }

        }
        f.close();
    }
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    void dfs(int r, int c, int moves){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || mat[r][c] =='#' || shadow[r][c]<=moves) return;
        shadow[r][c]=moves++;
        for (int i = 0; i < 4; i++) {
            dfs(r+dx[i], c+dy[i], moves);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new podracing().run();
    }
}
