import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob28{
    int[][] mat;
    int[][] shadow;

    ArrayList<Integer> result;
    int best;
    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob28".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        int n = f.nextInt();
        mat = new int[n][n];
        shadow = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(shadow[i], Integer.MIN_VALUE);
            for (int j = 0; j < n; j++) {
                mat[i][j] = f.nextInt();
            }
        }


        ArrayList<Integer> path = new ArrayList<>();
        best = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum(0, i, 0, path);
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            if(shadow[n-1][i]>max){
                max = shadow[n-1][i];
            }
        }

        System.out.print(best + ":");
        for (Integer i : result) {
            System.out.print(" " + i);
        }
        System.out.println();
        f.close();
    }
    void sum(int r, int c, int val, ArrayList<Integer> path){
        if(r <0  || c< 0 || r>=mat.length || c>= mat.length || shadow[r][c] >=val+mat[r][c]){
            return;
        }

        if (r == mat.length - 1) {
            if (best < val + mat[r][c]) {
                result = new ArrayList<>();
                result.addAll(path);
                result.add(mat[r][c]);
                best = val + mat[r][c];
            }
        }

        val+=mat[r][c];
        path.add(mat[r][c]);
        shadow[r][c] = val;
        sum(r+1, c, val, path);
        sum(r+1, c-1, val, path);
        sum(r+1, c+1, val, path);
        path.removeLast();
    }


    public static void main(String[] args) throws FileNotFoundException{
        new prob28().run();
    }
}
