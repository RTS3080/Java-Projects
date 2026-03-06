import java.io.*;
import java.util.*;

public class gopher {
    public static void main(String[] args) throws Exception {
        new gopher().run();
    }
    int[][][] shadow;
    char[][][] mat;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Judge/gopher.dat"));
        int times = f.nextInt();
        while(times-->0){
            int r = f.nextInt(), c = f.nextInt(); f.nextLine();
            int er = 0, ec = 0, sr = 0, sc = 0;
            mat = new char[2][r][c];
            shadow = new int[2][r][c];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < r; j++) {
                    char[] chs = f.nextLine().trim().toCharArray();
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                    for (int k = 0; k < c; k++) {
                        mat[i][j][k] = chs[k];
                        if(chs[k] == 'H'){
                            sr = j;
                            sc = k;
                        }
                        if(chs[k] == 'G'){
                            er = j;
                            ec = k;
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(mat[0][i][j] == 'O' && mat[1][i][j]!='O' || mat[1][i][j] == 'O' && mat[0][i][j]!='O'){
                        mat[0][i][j] = '.';
                        mat[1][i][j] = '.';
                    }
                }
            }
//            recur(sr,sc,0,0);
//            for(int[][] intss: shadow){
//                for(int[] ints : intss){
//                    for(int i : ints){
//                        System.out.print((i==Integer.MAX_VALUE ? "n" : i)+", ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("-".repeat(15));
//            }
//            for(char[][] intss: mat){
//                for(char[] ints : intss){
//                    System.out.println(Arrays.toString(ints));
//                }
//                System.out.println("-".repeat(15));
//            }
            dfs(sr, sc);
            int end = shadow[0][er][ec];
            System.out.println(end == Integer.MAX_VALUE?"Nowhere left to go-pher.": end);
        }
        
    }
    public void dfs(int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int []{sr,sc,0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int moves = cur[2];
            int s = cur[3];
            if(r<0 || c<0 || r>=mat[s].length || c>=mat[s][r].length ||
                    shadow[s][r][c] <= moves || mat[s][r][c] == '#'){
                continue;
            }
            shadow[s][r][c] = moves;
//            if(mat[s][r][c] == 'G'){
//                return;
//            }
            if(mat[s][r][c] == 'O'){
                s = (s+1)%2;
                shadow[s][r][c] = moves;
            }
            moves++;
            q.offer(new int []{r+1, c, moves, s});
            q.offer(new int []{r-1, c, moves, s});
            q.offer(new int []{r, c+1, moves, s});
            q.offer(new int []{r, c-1, moves, s});
        }
    }
    public void recur(int r , int c , int moves, int s){
        if(r<0 || c<0 || r>=mat[s].length || c>=mat[s][r].length ||
                shadow[s][r][c] <= moves || mat[s][r][c] == '#')
            return;
        shadow[s][r][c] = moves;
//        if(mat[s][r][c] == 'G'){
//            return;
//        }
        if(mat[s][r][c] == 'O'){
            s = (s+1)%2;
            shadow[s][r][c] = moves;
        }
        moves++;
        recur(r+1, c, moves, s);
        recur(r-1, c, moves, s);
        recur(r, c+1, moves, s);
        recur(r, c-1, moves, s);
    }
}