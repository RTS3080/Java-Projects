import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class monster{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("monster".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            ArrayList<Integer[]> scary = new ArrayList<>();
            int startR = 0;
            int startC = 0;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j]=='S'){
                        startR=i;
                        startC=j;
                    }
                    if(mat[i][j]=='M'){
                        scary.add(new Integer[]{i,j});
                    }
                }
            }

            for(Integer[] pairs : scary){
                for(int i = Math.max(0,pairs[0]-1); i<= Math.min(mat.length-1,pairs[0]+1); i++){
                    for(int j = Math.max(0,pairs[1]-1); j<= Math.min(mat[0].length-1,pairs[1]+1); j++){
                        mat[i][j] = 'M';
                    }
                }
            }
//            for(char[] chars : mat){
//                for(char c :chars){
//                    System.out.print(c);
//                }
//                System.out.println();
//            }

            recur(startR,startC,0);
            System.out.println(bmoves!= Integer.MAX_VALUE ? "MADE IT HOMEY" : "NO LUCK");
        }
        f.close();
    }

    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '0'
                || mat[r][c] == 'M' || moves>=shadow[r][c] || moves>=bmoves){
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

    public static void main(String[] args) throws FileNotFoundException{
        new monster().run();
    }
}
