import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class rat3{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    TreeSet<Integer> prevs;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("surf3".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = rows;
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            prevs = new TreeSet<>();
            int startR = 0;
            int startC = 0;
            int endR = 0;
            int endC = 0;
            for (int i = 0; i < rows; i++) {
                String[] ln = f.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = ln[j].charAt(0);
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j]=='M'){
                        startR=i;
                        startC=j;
                    }
                    if(mat[i][j]=='C'){
                        endR=i;
                        endC=j;
                    }
                }
            }

            recur(startR,startC,0);
//            System.out.println(bmoves);

            findPath(endR,endC,bmoves+1);
            mat[startR][startC]='M';
            mat[endR][endC]='C';
            for(char[] chs : mat){
                for(char ch : chs){
                    System.out.print(ch+" ");
                }
                System.out.println();
            }
            System.out.println();
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
    public void findPath(int r, int c,int prev){
        if(r<0 || c<0 || r>mat.length-1 || c>mat[0].length-1 || prev-1 !=shadow[r][c] || prevs.contains(prev)){
            return;
        }
        prevs.add(prev);
        int here = shadow[r][c];
        shadow[r][c] = -1;
        mat[r][c] = '+';
        findPath(r+1,c,here);
        findPath(r-1,c,here);
        findPath(r,c-1,here);
        findPath(r,c+1,here);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new rat3().run();
    }
}
