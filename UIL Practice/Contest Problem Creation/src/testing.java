import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class testing {
    char[][][] mat;
    int[][][] shadow;
    int best;

    public void dfs(int t, int r, int c) {
        // get current rotation
        int rot = (t / 3) % 4;

        // check bounds
        if (r < 0 || c < 0 || r >= mat[rot].length || c >= mat[rot][r].length) {
            return;
        }

        // check if we have already visited at a better pace
        if (t >= shadow[t % 12][r][c] || t >= best) {
            return;
        }

        // check for monsters and trash
        if ("Mm#".contains("" + mat[rot][r][c])) {
            return;
        }

        // store best possible time at this position
        // have to mod by 12 as being at time 0 and 2 is technically two different states
        shadow[t % 12][r][c] = t;

        // checking if we reached the exit
        if (mat[rot][r][c] == 'E') {
            best = t;
            return;
        }

        // setting all possible directions
        int[][] dirs = new int[][] {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;

            // checking next tile before rotating
            if (nr < 0 || nc < 0 || nr >= mat[rot].length || nc >= mat[rot][nr].length || "Mm#".contains("" + mat[rot][nr][nc])) {
                continue;
            }

            dfs(t + 1, nr, nc);
        }
    }

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("trash_judge.dat"));
        int times = f.nextInt();
        f.nextLine();

        while (times-- > 0) {
            int size = f.nextInt();
            int maxTime = f.nextInt();

            int sr = -1;
            int sc = -1;
            best = Integer.MAX_VALUE;

            // set up the maze matrix
            mat = new char[4][size][size];

            shadow = new int[12][size][size];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < size; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }

            for (int i = 0; i < size; i++) {
                mat[0][i] = f.next().toCharArray();
                for (int j = 0; j < size; j++) {
                    if (mat[0][i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            // pre-rotate the maze
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[1][j][size - i - 1] = mat[0][i][j];
                    mat[2][size - i - 1][size - j - 1] = mat[0][i][j];
                    mat[3][size - j - 1][i] = mat[0][i][j];
                }
            }

            // set up Dianoga monsters
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if ((i % 2 != 0 || mat[i][j][k] != 'M') && (i % 2 != 1 || mat[i][j][k] != 'm')) {
                            continue;
                        }
                        int shift = mat[i][j][k] == 'M' ? 1 : 2;
                        for (int dj = -shift; dj <= shift; dj++) {
                            for (int dk = -shift; dk <= shift; dk++) {
                                if (j + dj >= 0 && j + dj < size && k + dk >= 0 && k + dk < size && !"Mm".contains("" + mat[i][j + dj][k + dk])) {
                                    mat[i][j + dj][k + dk] = '#';
                                }
                            }
                        }
                    }
                }
            }

            dfs(0, sr, sc);
            System.out.println(best);
            if (best == Integer.MAX_VALUE) {
                System.out.println("Listen to them! They're dying R2!");
            } else if (best > maxTime) {
                System.out.println("Don't take so long Han.");
            } else {
                System.out.println("Shut down all garbage mashers on the Detention Level, will you?");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new testing().run();
    }
}