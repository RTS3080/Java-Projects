import java.util.*;
import java.io.*;
import java.awt.*;

public class cruise{
    int[][] mat;
    int[][] shadow;
    int d;
    int bmoves;
    int[] rmoves = new int[]{1,-1,0,0,1,1,-1,-1};
    int[] cmoves = new int[]{0,0,1,-1,1,-1,1,-1};
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cruise".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r= f.nextInt();
            int c= f.nextInt();
            d = f.nextInt();
            f.nextLine();
            mat=new int[r][c];
            shadow = new int[r][c];
            bmoves = Integer.MAX_VALUE;
            int startR = -1, startC = -1;
            for(int i=0;i<r;i++){
                String[] ln = f.nextLine().trim().split("\\s+");
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                for(int j=0;j<c;j++){
                    if(ln[j].equals("L")) {
                        mat[i][j] = -1;
                    }
                    else if(ln[j].equals("S")) {
                        startR = i;
                        startC = j;
                        mat[i][j] = 0;
                    }
                    else{
                        int a = Integer.parseInt(ln[j]);
                        if(a<=d){
                            mat[i][j]= 1;
                        }
                        else{
                            mat[i][j] = 0;
                        }
                    }
                }
            }
            recurShip(startR,startC);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == -1){
                        recurLand(i,j,0);
                        for (int k = 0; k < r; k++) {
                            Arrays.fill(shadow[k], Integer.MAX_VALUE);
                        }
                    }
                }
            }
            System.out.println(bmoves+" cell" + (bmoves==1?"":"s"));

        }
        f.close();
    }

    public void recurShip(int r, int c){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c]!=0){
            return;
        }
        mat[r][c] = -2;
        for(int i = 0; i< 8;i++){
            recurShip(r+rmoves[i],c+cmoves[i]);
        }
    }
    public void recurLand(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || moves >=shadow[r][c]){
            return;
        }
        shadow[r][c] = moves;
        if(mat[r][c] ==-1) moves--;
        if(mat[r][c] == -2){
            bmoves = Math.min(bmoves,moves);
        }
        moves++;
        for (int i = 0; i < 8; i++) {
            recurLand(r+rmoves[i],c+cmoves[i],moves);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new cruise().run();
    }
}
