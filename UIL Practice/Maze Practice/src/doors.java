import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class doors{
    char[][] mat;
    int[][][] shadow;
    int bestMoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("doors".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            int maxMoves = f.nextInt();
            int numDoors = 0;
            int sr = -1, sc = -1, er = -1, ec = -1;
            mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(Character.isLowerCase(mat[i][j])){
                        numDoors++;
                    }
                    if(mat[i][j] == ']'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j] == '['){
                        er = i;
                        ec = j;
                    }
                }
            }
            shadow = new int[1 << numDoors + 1][r][c];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < r; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            bestMoves = Integer.MAX_VALUE;
            dfs(0,sr,sc,0,"");
            if(bestMoves <= maxMoves){
                System.out.println("Amazeing Job. Escaped in "+bestMoves+" steps.");
            }
            else{
                System.out.println("Mother knows best.");
            }
        }
        f.close();
    }
    void dfs(int l, int r, int c, int moves, String keys){
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || shadow[l][r][c] <=moves || mat[r][c] == '#'){
            return;
        }
        if(Character.isAlphabetic(mat[r][c])){
            char ch = mat[r][c];
            if(Character.isLowerCase(ch)){
                l |= (1 << ch+1-'a');
                keys += Character.toUpperCase(ch);
            }
            if(Character.isUpperCase(ch)){
                if(!keys.contains(""+ch)){
                    return;
                }
            }
        }
        if(mat[r][c] == '['){
            bestMoves = Math.min(bestMoves, moves);
        }
        shadow[l][r][c] = moves++;
        dfs(l, r+1, c, moves, keys);
        dfs(l, r-1, c, moves, keys);
        dfs(l, r, c+1, moves, keys);
        dfs(l, r, c-1, moves, keys);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new doors().run();
    }
}
