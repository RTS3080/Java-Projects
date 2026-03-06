import java.util.*;
import java.io.*;

public class wesley{
    char[][] mat;
    int[][][] shadow;

    public void recur(int d, int r, int c, int steps) {
        d  = (d+1)%5;
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || steps >= shadow[d][r][c]) return;

        if (d == 0 && (mat[r][c] == '#' || mat[r][c] == '3' || mat[r][c] == '5')) {
            return;
        } else if (d == 2 && (mat[r][c] == '#' || mat[r][c] == '1' || mat[r][c] == '5')) {
            return;
        } else if (d == 4 && (mat[r][c] == '#') ||  mat[r][c] == '1' || mat[r][c] == '3') {
            return;
        } else if (d == 3 && mat[r][c] != '#' && mat[r][c] != '1' && mat[r][c] != '3' && mat[r][c] != '5') {
            return;
        }


        shadow[d][r][c] = steps;
        recur(d, r - 1, c, steps + 1);
        recur(d, r + 1, c, steps + 1);
        recur(d, r, c - 1, steps + 1);
        recur(d, r, c + 1, steps + 1);
        recur(d, r, c, steps + 1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wesley".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[5][rows][cols];

            int sr = -1, sc = -1, er = -1, ec = -1;

            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    } if (mat[i][j] == 'E') {
                        er = i;
                        ec = j;
                    }
                }

                for (int j = 0; j < 5; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
            }

            if (er == -1) {
                System.out.println("Guess I won't be home in time for dinner.");
                continue;
            }

            recur(0, sr, sc, 0);
            boolean solved = false;
            for (int i = 0; i < 5; i++) {
                solved |= shadow[i][er][ec] < Integer.MAX_VALUE;
            }
            if (solved){
                System.out.println("The Great Escape.");
            } else {
                System.out.println("Guess I won't be home in time for dinner.");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new wesley().run();
    }
}
