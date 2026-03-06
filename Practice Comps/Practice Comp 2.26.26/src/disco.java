import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class disco{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("disco".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        int day = 0;
        while(times-->0){
            day++;
            int sr = f.nextInt() - 1;
            int sc = f.nextInt() - 1;

            char[][][] mat = new char[4][9][9];
            for (int i = 0; i < 9; i++) {
                mat[0][i] = f.next().toCharArray();
            }

            for (int i = 1; i < 4; i++) {
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        mat[i][r][c] = mat[i - 1][8 - c][r];
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            int[][][] vis = new int[4][9][9];
            for (int i = 0; i < vis.length; i++) {
                for (int j = 0; j < vis[i].length; j++) {
                    Arrays.fill(vis[i][j], Integer.MAX_VALUE);
                }
            }

            LinkedList<Integer> q = new LinkedList<>();
            q.add(0); q.add(sr); q.add(sc); q.add(0);

            while (!q.isEmpty()){
                int rot = q.poll();
                int r = q.poll();
                int c = q.poll();
                int rotations = q.poll();

                if (r < 0 || c < 0 || r >= 9 || c >= 9) continue;

                if (rotations >= vis[rot][r][c]) {
                    continue;
                }

                vis[rot][r][c] = rotations;

                if (r + c == 0) {
                    res = Math.min(res, rotations);
                }

                q.add((rot + 1) % 4); q.add(r); q.add(c); q.add(rotations + 1);

                int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < 9 && nc < 9 && mat[rot][nr][nc] == mat[rot][r][c]) {
                        q.add(rot); q.add(nr); q.add(nc); q.add(rotations);
                    }
                }
            }

//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < vis[i].length; j++) {
//                    System.out.println(Arrays.toString(vis[i][j]).replace(Integer.MAX_VALUE + "", "-1"));
//                }
//                System.out.println("----------------");
//            }

            if (res == Integer.MAX_VALUE) {
                System.out.println("I'm the next ingredient in disco stew #" + day + "!");
            } else {
                System.out.println("I escaped disco #" + day + " in " + res + " turn(s) of the disco ball.");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new disco().run();
    }
}
