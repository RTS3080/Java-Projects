import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class prob26{
    char[][] mat;
    char[][] res;
    char[][] copy;
    int[][] shadow;
    int best;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int rows = f.nextInt(); int cols = f.nextInt();
        f.nextLine();
        mat = new char[rows][cols];
        shadow = new int[rows][cols];
        res = new char[rows][cols];
        copy = new char[rows][cols];
        best = Integer.MAX_VALUE;
        int startR = -1, startC = -1, endR = -1, endC = -1;
        for (int i = 0; i < rows; i++) {
            mat[i] = f.next().toCharArray();
            for (int j = 0; j < cols; j++) {
                res[i][j] = '.';
                shadow[i][j] = Integer.MAX_VALUE;
                if (mat[i][j] == '#') res[i][j] = '#';
                if (mat[i][j] == '*') {
                    startR = i;
                    startC = j;
                }
                if (mat[i][j] == '@') {
                    endR = i;
                    endC = j;
                }
            }
        }

        recur(startR,startC,0);

        copy[startR][startC] = '*';
        copy[endR][endC] = '@';
        System.out.println(best + " seconds");
        for (char[] line : copy) {
            System.out.println(line);
        }

        f.close();
    }

    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
                || moves>=shadow[r][c] || moves + 1 >= best){
            return;
        }
        if (moves + 1 < best && mat[r][c] == '@') {
            best = moves + 1;
            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[i].length; j++) {
                    copy[i][j] = res[i][j];
                }
            } return;
        }
        shadow[r][c] = moves;
        res[r][c] = mat[r][c];
        int inc = 0;
        if (Character.isDigit(mat[r][c])) {
            inc = mat[r][c] - 48;
        } else if (Character.isAlphabetic(mat[r][c])) {
            inc = mat[r][c] - 'A' + 10;
        }
        moves += inc;
        recur(r+1,c,moves);
        recur(r,c+1,moves);
        recur(r-1,c,moves);
        recur(r,c-1,moves);
        res[r][c] = '.';
    }

    public static void main(String[] args) throws FileNotFoundException{
        new prob26().run();
    }
}
