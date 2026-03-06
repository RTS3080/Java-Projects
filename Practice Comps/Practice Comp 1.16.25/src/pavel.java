import java.util.*;
import java.io.*;

public class pavel{
    char[][] mat;
    int[][] shadow;
    int best;

    public boolean checkOut(int r, int c) {
        return r < 0 || c < 0 || r >= mat.length || c >= mat[r].length;
    }

    public void recur(int r, int c, int steps) {
        if (checkOut(r, c)) {
            return;
        }

        if (steps >= shadow[r][c] || mat[r][c] == '#') return;

        if (mat[r][c] == 'E') best = steps;

        shadow[r][c] = steps;

        System.out.println(r + " " + c);

        if (mat[r][c] == '.' || mat[r][c] == 'S') {
            int nr = r - 1;
            int nc = c;

            if (checkOut(nr, nc)) {
                int ns = mat[nr][nc] == '.' || mat[nr][nc] == 'E' ? 1 : (mat[nr][nc] - '0' + 4 - steps % 4) % 4;
                recur(nr, nc, ns);
            }

            nr = r + 1;
            nc = c;

            if (checkOut(nr, nc)) {
                int ns = mat[nr][nc] == '.' || mat[nr][nc] == 'E' ? 1 : (mat[nr][nc] - '0' + 4 - steps % 4) % 4;
                recur(nr, nc, ns);
            }

            nr = r;
            nc = c + 1;

            if (checkOut(nr, nc)) {
                int ns = mat[nr][nc] == '.' || mat[nr][nc] == 'E' ? 1 : (mat[nr][nc] - '0' + 4 - steps % 4) % 4;
                recur(nr, nc, ns);
            }

            nr = r;
            nc = c - 1;

            if (checkOut(nr, nc)) {
                int ns = mat[nr][nc] == '.' || mat[nr][nc] == 'E' ? 1 : (mat[nr][nc] - '0' + 4 - steps % 4) % 4;
                recur(nr, nc, ns);
            }
        } else {
            char cycle = (char) (steps % 4 + 1 + '0');

            int nr = r - 1;
            int nc = c;

            if (checkOut(nr, nc) && mat[nr][nc] == cycle) {
                recur(nr, nc, steps + 1);
            }

            nr = r + 1;
            nc = c;

            if (checkOut(nr, nc) && mat[nr][nc] == cycle) {
                recur(nr, nc, steps + 1);
            }

            nr = r;
            nc = c + 1;

            if (checkOut(nr, nc) && mat[nr][nc] == cycle) {
                recur(nr, nc, steps + 1);
            }

            nr = r;
            nc = c - 1;

            if (checkOut(nr, nc) && mat[nr][nc] == cycle) {
                recur(nr, nc, steps + 1);
            }
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pavel".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            int maxSteps = f.nextInt(); f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            best = Integer.MAX_VALUE;

            int sr = -1, sc = -1;

            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().trim().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
            }

            recur(sr, sc, 0);

            if (best == Integer.MAX_VALUE) {
                System.out.println("Aw, rats!");
                System.out.println("I'll see you in the Gulag Pavel.");
            } else {
                System.out.println(best + " steps.");
                System.out.println(best <= maxSteps ? "I have had enough of these snakes." : "I'll see you in the Gulag Pavel.");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pavel().run();
    }
}
