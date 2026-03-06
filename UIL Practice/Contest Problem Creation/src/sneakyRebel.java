import java.util.*;
import java.io.*;
import java.awt.*;

public class sneakyRebel{

    int[][] shadow;
    boolean[][][] vis;
    char[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sneakyJudge".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r= f.nextInt();
            int c= f.nextInt(); f.nextLine();
            mat = new char[r][c];
            shadow = new int[r][c];
            vis = new boolean[6][r][c];
            ArrayList<int[]> sith = new ArrayList<>();
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < r; i++) {
                String[] ln = f.nextLine().split(" ");

                Arrays.fill(shadow[i], Integer.MIN_VALUE);
                for (int j = 0; j < c; j++) {
                    mat[i][j] = ln[j].charAt(0);
                    if(mat[i][j] == 'X'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j] == 'E'){
                        er = i;
                        ec = j;
                    }
                    if(mat[i][j] == 'S'){
                       sith.add(new int[]{i, j});
                    }
                }
            }
            for(int[] pt : sith){
                for(int i =  Math.max(0, pt[0]-1); i<= Math.min(pt[0]+1, mat.length-1);i++){
                    for(int j =  Math.max(0, pt[1]-1); j<= Math.min(pt[1]+1, mat[i].length-1);j++){
                        if(i== pt[0] && j== pt[1]){
                            continue;
                        }
                        mat[i][j] = 's';
                    }
                }
            }
//            for (int i = 0; i < r; i++) {
//                System.out.println(mat[i]);
//            }
            dfs(5, sr,sc);

            boolean best = shadow[er][ec]>0;
            for (int i = 0; i < 6; i++) {
//                best |= vis[i][er][ec];
//                for (int j = 0; j < r; j++) {
//                    for (int k = 0; k < c; k++) {
//                        System.out.print((vis[i][j][k]?"T":"F")+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("-------");
            }
            System.out.println(best?"True":"False");
        }
        f.close();
    }
    void dfs(int h, int r, int c){
        if(h<0 || r< 0 || c< 0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '1'
                || shadow[r][c] >= h || vis[h][r][c]) return;
        shadow[r][c] = h;
        vis[h][r][c] = true;
        if(mat[r][c] == 'S'){
            h-=2;
        }
        else if (mat[r][c] == 's'){
            h--;
        }
        else if(mat[r][c] == '0'){
            h++;
        }
        if(h<= 0) return;
        h = Math.min(5, h);
        char save = mat[r][c];
        if (save == '0') mat[r][c] = '.';
        dfs(h, r, c+1);
        dfs(h, r, c-1);
        dfs(h, r-1, c);
        dfs(h, r+1, c);
        mat[r][c] = save;
    }
    

    public static void main(String[] args) throws FileNotFoundException{
        new sneakyRebel().run();
    }
}
