import java.util.*;
import java.io.*;
import java.awt.*;

public class wyatt{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wyatt".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt(), c = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for(int i=0; i<r; i++){
                mat[i] = f.next().toCharArray();
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                for(int j=0; j<c; j++){
                    if((mat[i][j]+"").matches("[o^~]")){
                        mat[i][j] = '#';
                    }
                    if(mat[i][j]=='T'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j]=='P'){
                        er = i;
                        ec = j;
                    }
                }
            }
            if(sr == -1 || er == -1)
            {
                System.out.println("No Can Do");
            }
            else {
                recur(sr, sc, 0);

                int end = shadow[er][ec];
                if (end == Integer.MAX_VALUE) {
                    System.out.println("No Can Do");
                } else System.out.println("PHForestry");
            }
        }
        f.close();
    }
    int[] dx = {-1, 1, 0 , 0};
    int[] dy = {0, 0, 1 , -1};
    void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c]=='#'
                || shadow[r][c]<=moves) return;
        shadow[r][c] = moves++;
        for (int i = 0; i < 4; i++) {
            recur(r + dx[i], c + dy[i], moves);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new wyatt().run();
    }
}
