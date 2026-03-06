import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class warming {
    char[][] newMat;
    boolean[][] vis;

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("warming".toLowerCase() + ".in"));
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt();
            int c = f.nextInt();
            int decrease = f.nextInt();
            char[][] mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (Character.isDigit(mat[i][j])) {
                        int a = mat[i][j] - '0';
                        a -= decrease;
                        if (a <= 0) {
                            mat[i][j] = 'w';
                        } else {
                            mat[i][j] = (char) (a + '0');
                        }
                    }
                }
            }
            vis = new boolean[r + 2][c + 2];
            newMat = new char[r + 2][c + 2];
            for (char[] chars : newMat) {
                Arrays.fill(chars, '.');
            }
            for (int i = 1; i < r + 1; i++) {
                System.arraycopy(mat[i - 1], 0, newMat[i], 1, c + 1 - 1);
            }

            blob(0, 0);
            for (int i = 1; i < r + 1; i++) {
                String out = "";
                for (int j = 1; j < c + 1; j++) {
                    out += newMat[i][j];
                }
                System.out.println(out);
            }

        }
        f.close();
    }

    void blob(int r, int c) {
        if (r < 0 || c < 0 || r >= newMat.length || c >= newMat[0].length || vis[r][c]
                || Character.isDigit(newMat[r][c])) return;
        vis[r][c] = true;
        if (newMat[r][c] == 'w') {
            newMat[r][c] = '.';
        }

        blob(r + 1, c);
        blob(r - 1, c);
        blob(r, c + 1);
        blob(r, c - 1);
    }


    public static void main(String[] args) throws FileNotFoundException {
        new warming().run();
    }
}
