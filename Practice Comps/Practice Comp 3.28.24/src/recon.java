import java.util.*;
import java.io.*;

public class recon{
    public static char[][] mat;
    public static int[][] shadow;
    public static int[][] clear;
    public static int bmoves;
    public static char no='X';
    public static int times;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("recon".toLowerCase()+".dat"));
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r=f.nextInt();
            int c=f.nextInt();f.nextLine();
            int startR=0,startC=0;
            mat=new char[r][c];
            shadow=new int[r][c];
            clear=new int[r][c];
            for (int i = 0; i < r; i++) {
                char[] ch=f.nextLine().toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                Arrays.fill(clear[i],Integer.MAX_VALUE);
                for (int j = 0; j < c; j++) {
                    mat[i][j]=ch[j];
                    if(mat[i][j]=='S'){
                        startR=i;
                        startC=j;
                    }
                }
            }
            bmoves=Integer.MAX_VALUE;
            recur(startR,startC,0);
            System.out.println(bmoves==Integer.MAX_VALUE?"YA FIRED":"YA HIRED");
        }
        f.close();
    }
    public static void recur(int r, int c, int moves){
        if(r>-1 && c>-1 && r<mat.length && c<mat[r].length && mat[r][c]!='#' && shadow[r][c]>moves && mat[r][c]!=no){
            shadow[r][c]=moves;
            if(mat[r][c]=='K'){
                no='4';
                mat[r][c]='.';
                shadow=clear;
            }
            if(mat[r][c] == 'X'){
                bmoves=moves;
                return;
            }
            recur(r+1,c,moves+1);
            recur(r-1,c,moves+1);
            recur(r,c+1,moves+1);
            recur(r,c-1,moves+1);
        }
    }
}
