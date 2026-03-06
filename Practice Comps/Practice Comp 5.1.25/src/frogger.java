import java.util.*;
import java.io.*;
import java.awt.*;

public class frogger{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("frogger".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt(); int c = f.nextInt(); f.nextLine();
            int startr = -1, startc = -1, endr = -1, endc = -1;
            mat = new char[r][c];
            shadow = new int[r][c];
            for(int i=0;i<r;i++){
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                mat[i]=f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(mat[i][j]=='$'){
                        startr=i;
                        startc=j;
                    }
                    if(mat[i][j]=='@'){
                        endr=i;
                        endc=j;
                    }
                    if(Character.isDigit(mat[i][j])){
                        mat[i][j]-='0';
                    }
                }
            }
            recur(startr, startc, 1);

            System.out.println(shadow[endr][endc]);
//            for(int[] i : shadow){
//                for(int j : i){
//                    System.out.printf("%2d ",(j==Integer.MAX_VALUE?-1 : j));
//                }
//                System.out.println();
//            }
        }
        f.close();
    }
    void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || mat[r][c]=='*' || moves>shadow[r][c]){
            return;
        }
        shadow[r][c] = moves++;
        int change = 1;
        if(mat[r][c] <10){
            change += mat[r][c];
        }
        int[] rmoves = new int[]{change, -change, 0,0};
        int[] cmoves = new int[]{0,0,-change, change};
        for (int i = 0; i < 4; i++) {
            recur(rmoves[i]+r, cmoves[i]+c, moves);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new frogger().run();
    }
}
