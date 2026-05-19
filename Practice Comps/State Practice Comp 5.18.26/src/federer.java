import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class federer{
    char[][] mat;
    int[][][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("federer".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r= f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            int sr = -1, sc = -1, er = -1, ec = -1;
            int numBalls = 0;
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j] == 'T'){
                        er = i;
                        ec = j;
                    }
                    if(Character.isDigit(mat[i][j])){
                        numBalls = Math.max(numBalls, mat[i][j]-'0');
                    }
                }
            }
            shadow = new int[numBalls+1][r][c];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            endR = sr;
            endC = sc;
            int moves = 0;
            boolean possible = true;
            for (int i = 0; i <= numBalls; i++) {
                bmoves = Integer.MAX_VALUE;
                char target = i==numBalls?'T':(char)(i+'1');
                dfs(i, endR, endC, 0, target);
                moves+=bmoves;
                if(bmoves == Integer.MAX_VALUE){
                    possible = false;
                }
            }


//            int minMoves = shadow[
//            for (int i = 0; i < shadow.length; i++) {
//                for (int j = 0; j < shadow[i].length; j++) {
//                    System.out.println(Arrays.toString(shadow[i][j]));
//                }
//                System.out.println();
//            }
//            System.out.println();
            System.out.println(possible ? moves : -1);
//            System.out.println();
        }
        f.close();
    }
    int endR;
    int endC;
    int bmoves;
    void dfs(int l, int r, int c, int moves, int target){
        if(l >=shadow.length || r <0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
        ||shadow[l][r][c] <=moves){
            return;
        }
        shadow[l][r][c] = moves;
        if(mat[r][c]==target && shadow[l][r][c] < bmoves){
            endR = r;
            endC = c;
            bmoves = moves;
        }
        moves++;
        dfs(l, r+1, c, moves, target);
        dfs(l, r-1, c, moves, target);
        dfs(l, r, c+1, moves, target);
        dfs(l, r, c-1, moves, target);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new federer().run();
    }
}
