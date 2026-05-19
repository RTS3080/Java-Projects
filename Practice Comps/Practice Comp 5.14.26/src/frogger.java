import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class frogger{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("frogger".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int R = 11;
            int C = 15;

            char[][] map = new char[R][C];
            int[][][] mat = new int[15][R][C];

            for (int i = 0; i < R; i++) {
                map[i] = f.next().toCharArray();

                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '#') {
                        mat[0][i][j] = 1;

                        for (int k = 0; k < 15; k++) {
                            mat[k][i][(j + k) % 15] = 1;
                        }
                    }

                    if (map[i][j] == '@') {
                        mat[0][i][j] = 2;

                        for (int k = 0; k < 15; k++) {
                            mat[k][i][(j - k + 15) % 15] = 2;
                        }
                    }

                    if (map[i][j] == '^' || map[i][j] == '~') {
                        for (int k = 0; k < 15; k++) {
                            mat[k][i][j] = 1;
                        }
                    }
                }
            }

            LinkedList<Integer> q = new LinkedList<>();

                q.add(R - 1); q.add(7); q.add(0);

            int[][][] shad = new int[C][R][C];
            for (int[][] ints : shad) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, Integer.MAX_VALUE);
                }
            }

            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();
                int b = t % C;

                if (r < 0 || c < 0 || r >= R || c >= C) continue;

                if (r == 0) {
                    System.out.println(t);
                    break;
                }

                if (t >= shad[b][r][c]) continue;
                shad[b][r][c] = t;

                if (mat[b][r][c] == 1) continue;

                if (mat[b][r][c] == 2) {
                    q.add(r); q.add(c - 1); q.add(t + 1);
                    q.add(r); q.add(c - 2); q.add(t + 1);
                    q.add(r - 1); q.add(c); q.add(t + 1);
                    q.add(r); q.add(c); q.add(t + 1);
                } else {
                    q.add(r); q.add(c); q.add(t + 1);
                    q.add(r); q.add(c - 1); q.add(t + 1);
                    q.add(r); q.add(c + 1); q.add(t + 1);
                    q.add(r - 1); q.add(c); q.add(t + 1);
                }
            }


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new frogger().run();
    }
}
