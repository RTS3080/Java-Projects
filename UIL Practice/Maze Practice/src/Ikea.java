import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Ikea{
    char[][][] mat;
    int[][][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ikea".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int l = f.nextInt();
            int r = f.nextInt();
            int c = f.nextInt();
            int numFurniture = f.nextInt();
            mat = new char[l][r][c];
            shadow = new int[l][r][c];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < l; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            int[] starts = new int[3];
            int[] ends = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    mat[i][j] = f.next().toCharArray();
                    for (int k = 0; k < c; k++) {
                        if(mat[i][j][k] == 'S'){
                            starts[0] = i;
                            starts[1] = j;
                            starts[2] = k;
                        }
                        if(mat[i][j][k] == 'E'){
                            ends[0] = i;
                            ends[1] = j;
                            ends[2] = k;
                        }
                    }
                }
            }

            int min = shadow[ends[0]][ends[1]][ends[2]];
            System.out.println(min == Integer.MAX_VALUE ? "IKEAnnot do it." : "IKEAn do it.");
        }
        f.close();
    }
    void dfs(int l, int r, int c, int moves, int collected){
        if(l < 0 || r < 0 || c < 0 || l >= mat.length || r >= mat[0].length || c >= mat[0][0].length || mat[l][r][c] == '#'
        || shadow[l][r][c] <= moves){
            return;
        }
        if(Character.isDigit(mat[l][r][c])){
            int digit = mat[l][r][c]-'0';
            if(digit != collected+1) return;
            collected++;
        }
        shadow[l][r][c] = moves++;
        if(mat[l][r][c] == 'Z'){
            dfs( l+1, r, c, moves, collected);
            dfs( l-1, r, c, moves, collected);
        }
        else{
            dfs( l, r-1, c, moves, collected);
            dfs( l, r+1, c, moves, collected);
            dfs( l, r, c+1, moves, collected);
            dfs( l, r, c-1, moves, collected);

        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ikea().run();
    }
}
