import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class frankenstein{
    char[][] mat;
    int[][] shadow,path;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("frankenstein".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols =rows;
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            path = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            int startR = -1;
            int startC = -1;
            int endR = -1;
            int endC = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if (mat[i][j] == '@') {
                        startR = i;
                        startC = j;
                    }
                    if (mat[i][j] == '!') {
                        endR = i;
                        endC = j;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < rows; i++) {
                char[] h=new char[cols];
                Arrays.fill(h, '#');
                mat[i]=h;
            }

            recur(startR,startC,0,5);
            int t=endR,g=endC;
            while (path[t][g]!=5){
                mat[t][g] = '*';
                switch(path[t][g]){
                    case 1: t--; break;
                    case 2: t++; break;
                    case 3: g++; break;
                    case 4: g--; break;
                }
            }
            mat[t][g]='*';
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        f.close();
    }

    public void recur(int r, int c, int moves,int p){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] =='#'
                || moves>=shadow[r][c]){
            return;
        }
        shadow[r][c] = moves;
//        path[r][c] = p;
        if(mat[r][c]=='!'){
            bmoves = moves;
            return;
        }

        recur(r+1,c,moves+1,1);
        recur(r-1,c,moves+1,2);
        recur(r,c-1,moves+1,3);
        recur(r,c+1,moves+1,4);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new frankenstein().run();
    }
}
