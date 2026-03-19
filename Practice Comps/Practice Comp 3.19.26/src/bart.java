import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bart{
    char[][] mat;
    HashMap<Character, int[]> portals;
    int[][] shadow;
    int[][][] blackHole;
    int holeR, holeC;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bart".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r= f.nextInt(), c = f.nextInt();
            mat = new char[r][c];
            shadow = new int[r][c];
            blackHole = new int[Math.max(r, c) + 10][r][c];
            portals = new HashMap<>();
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < r; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == '$'){
                        sr = i;
                        sc= j;
                    }
                    if(mat[i][j] == '^'){
                        er = i;
                        ec = j;
                    }
                    if(Character.isLowerCase(mat[i][j])){
                        portals.put(Character.toUpperCase(mat[i][j]), new int[]{i,j});
                    }
                    if(mat[i][j] == '@'){
                        holeR = i;
                        holeC = j;
                    }
                }
            }
            for (int i = 0; i < blackHole.length; i++) {
                blackHole[i] = setBlackHole(r, c, i*3);
            }
//            setBlackHole(6);
//            System.out.println(holeR +" "+holeC);
//            for(int[] a : blackHole){
//                System.out.println(Arrays.toString(a));
//            }

            dfs(sr, sc, 0);
            int out = shadow[er][ec];
            System.out.println(out==Integer.MAX_VALUE ? "Tell Matthew Mcconaughey I said hi." : "Exit is short for exciting. "+out);
        }
        f.close();
    }
    void dfs(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || shadow[r][c] <=moves || mat[r][c] == '#'){
            return;
        }
        if(blackHole[moves/3][r][c] == -1) return;

        shadow[r][c] = moves;

        if(Character.isUpperCase(mat[r][c])){
            int[] output = portals.get(mat[r][c]);
            dfs(output[0], output[1], moves + (mat[r][c]-'A' +1));
        }
        moves+=blackHole[moves/3][r][c] == 1 ? 2 : 1;
        dfs(r+1, c, moves);
        dfs(r-1, c, moves);
        dfs(r, c+1, moves);
        dfs(r, c-1, moves);
    }
    int[][] setBlackHole(int r, int c, int moves){
        int[][] blackHole = new int[r][c];
        moves/=3;
        moves+=2;
        for(int i = Math.max(0, holeR - moves); i<holeR + moves && i < blackHole.length;i++){
            for(int j = Math.max(0, holeC - moves); j<holeC + moves && j < blackHole[holeR].length;j++){
                blackHole[i][j] = 1;
            }
        }
        moves-=2;
        for(int i = Math.max(0, holeR - moves); i<holeR + moves && i < blackHole.length;i++){
            for(int j = Math.max(0, holeC - moves); j<holeC + moves && j < blackHole[holeR].length;j++){
                blackHole[i][j] = -1;
            }
        }
        blackHole[holeR][holeC] = -1;
        return blackHole;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bart().run();
    }
}
