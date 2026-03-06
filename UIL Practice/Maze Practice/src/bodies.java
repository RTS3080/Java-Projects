import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class bodies{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bodies".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            ArrayList<ArrayList<Integer>>popo = new ArrayList<>();
            int startR = -1;
            int startC = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if (mat[i][j] == 'T') {
                        startR = i;
                        startC = j;
                    }
                    if(mat[i][j] == 'P'){
                        popo.add(new ArrayList<>(Arrays.asList(i,j)));
                    }
                }
            }
            for(ArrayList<Integer> row : popo){
                clearArea(row.get(0),row.get(1));
            }
            recur(startR,startC,0);
            System.out.print("Bravo Six Going Dark... ");
            System.out.println(bmoves!= Integer.MAX_VALUE ? "at the end of the tunnel is a light." :
                    "Mission Failed. We'll get em next time.");
        }
        f.close();
    }

    public void clearArea(int r,int c) {
        for (int i = Math.max(0, r - 1); i <= Math.min(mat.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(mat[0].length - 1, c + 1); j++) {
                mat[i][j] = '#';
            }
        }
    }
    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
                || moves>=shadow[r][c]){
            return;
        }
        shadow[r][c] = moves;
        if(mat[r][c]=='S'){
            bmoves = moves;
        }

        recur(r+1,c,moves+1);
        recur(r-1,c,moves+1);
        recur(r,c-1,moves+1);
        recur(r,c+1,moves+1);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new bodies().run();
    }
}
