import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class rat2{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("surf2".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = rows;
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            int startR = 0;
            int startC = 0;
            for (int i = 0; i < rows; i++) {
                String[] ln = f.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = ln[j].charAt(0);
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j]=='M'){
                        startR=i;
                        startC=j;
                    }
                }
            }

            recur(startR,startC,0);
            System.out.println(bmoves);
        }
        f.close();
    }

    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
                || moves>=shadow[r][c]){
            return;
        }
        shadow[r][c] = moves;
        if(mat[r][c]=='C'){
            bmoves = moves;
            return;
        }

        recur(r+1,c,moves+1);
        recur(r-1,c,moves+1);
        recur(r,c-1,moves+1);
        recur(r,c+1,moves+1);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new rat2().run();
    }
}
