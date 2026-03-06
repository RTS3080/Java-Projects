import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class basicMaze{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    TreeSet<Integer> prevs;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("two".toLowerCase()+".dat"));
        int times=f.nextInt();
        while(times-->0){
            int rows = 20; int cols = 20;
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            prevs = new TreeSet<>();
            int startR = -1;
            int startC = -1;
            int endR = -1;
            int endC = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j]=='S'){
                        startR=i;
                        startC=j;
                    }
                    if(mat[i][j]=='E'){
                        endR=i;
                        endC=j;
                    }
                }
            }
//            System.out.println(Arrays.deepToString(mat));
            boolean valid = !(startR==-1 || startC==-1 || endR==-1 || endC==-1);
            if(!valid){
                System.out.println("Invalid Input");
            }
            else {
                recur(startR, startC, 0);
                System.out.println(bmoves != Integer.MAX_VALUE ? "True " + bmoves : "False");
            }

            if(valid) {
                findPath(endR, endC, bmoves + 1);
                for (char[] chs : mat) {
                    for (char ch : chs) {
                        System.out.print(ch + " ");
                    }
                    System.out.println();
                }
            }
        }
        f.close();
    }

    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>mat.length-1 || c>mat[0].length-1 || mat[r][c] == '0' || moves>=shadow[r][c]){

            return;
        }
        shadow[r][c] = moves;
        if(mat[r][c]=='E'){
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
        mat[r][c] = '#';
        findPath(r+1,c,here);
        findPath(r-1,c,here);
        findPath(r,c-1,here);
        findPath(r,c+1,here);
    }
    public void mazePrint(){
        for (char[] chs : mat) {
            for (char ch : chs) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new basicMaze().run();
    }
}
