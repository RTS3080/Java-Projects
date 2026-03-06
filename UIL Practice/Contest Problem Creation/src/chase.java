import java.util.*;
import java.io.*;
import java.awt.*;

public class chase{
    char[][][] mat;
    int[][][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("chase".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int l = f.nextInt();
            int r = f.nextInt();
            int c = f.nextInt();
            int sl = -1, sr = -1, sc = -1, el = -1, er = -1, ec = -1;
            mat = new char[l][r][c];
            shadow = new int[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    mat[i][j] = f.next().toCharArray();
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                    for (int k = 0; k < c; k++) {
                        if(mat[i][j][k] == 'O'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                        if(mat[i][j][k] == 'J'){
                            el = i;
                            er = j;
                            ec = k;
                        }
                    }
                }
            }
            bmoves = Integer.MAX_VALUE;
            bfs(sl, sr, sc);
//            dfs(sl, sr, sc, 0);
            System.out.println(bmoves!=Integer.MAX_VALUE?"Let's get him R4, only "+bmoves+" seconds.":"He's gone.");
        }
        f.close();
    }
    void bfs(int sl, int sr, int sc){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{sl,sr,sc, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int l = cur[0];
            int r = cur[1];
            int c = cur[2];
            int m = cur[3];
            if(l<0 || r<0 || c<0 || l>=mat.length || r>=mat[l].length || c>=mat[l][r].length
                    || mat[l][r][c] == '#' || shadow[l][r][c]<=m || m>=bmoves){
                continue;
            }
            if(mat[l][r][c] == 'J'){
                bmoves = m;
                return;
            }
            shadow[l][r][c] = m++;
            q.offer(new int[]{l-1,r,c,m});
            q.offer(new int[]{l+1,r,c,m});
            q.offer(new int[]{l,r-1,c,m});
            q.offer(new int[]{l,r+1,c,m});
            q.offer(new int[]{l,r,c-1,m});
            q.offer(new int[]{l,r,c+1,m});
        }
    }
    void dfs(int l, int r, int c, int moves){
        if(l<0 || r<0 || c<0 || l>=mat.length || r>=mat[l].length || c>=mat[l][r].length
                || mat[l][r][c] == '#' || shadow[l][r][c]<=moves || moves>=bmoves){
            return;
        }
        if(mat[l][r][c] == 'J'){
            bmoves = moves;
        }
        shadow[l][r][c] = moves++;

        dfs(l-1, r, c, moves);
        dfs(l+1, r, c, moves);
        dfs(l, r-1, c, moves);
        dfs(l, r+1, c, moves);
        dfs(l, r, c+1, moves);
        dfs(l, r, c-1, moves);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new chase().run();
    }
}
