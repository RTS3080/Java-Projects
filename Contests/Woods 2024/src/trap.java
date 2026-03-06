import java.util.*;
import java.io.*;

public class trap {
    char[][] mat;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Trap.dat".toLowerCase()));

        int t = f.nextInt();
        run : while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt(), sr = f.nextInt(), sc = f.nextInt();
            char dir = f.next().charAt(0);
            int mag = f.nextInt();
            mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
            }
            int r = sr, c = sc, idx = 0;
            if (sr == row / 2) {
                if (sc < col / 2) {
                    idx = 3;
                }
                else {
                    idx = 2;
                }
            }
            if (sc == col / 2) {
                if (sr < row / 2) {
                    idx = 1;
                }
                else {
                    idx = 0;
                }
            }
            while (mat[r][c] != 'E') {
                if (mat[r][c] == '@') {
                    System.out.println("Goodbye world.");
                    continue run;
                }
                if (mat[r][c] == '#') {
                    System.out.println("Trapped.");
                    continue run;
                }
                rotate(dir, mag);
                r = r + vr[idx];
                c = c + vc[idx];
            }
            System.out.println("New candies are mine.");
        }

        f.close();
    }

    public void rotate(char dir, int mag) {
        if (dir == 'L') {
            mag = -mag;
        }
        for (int i = 0; i < mat.length / 2; i++) {
            ArrayList<Character> l = new ArrayList<>();
            for (int j = i; j < mat.length - i - 1; j++) {
                l.add(mat[i][j]);
            }
            for (int j = i; j < mat.length - i - 1; j++) {
                l.add(mat[j][mat[0].length - i - 1]);
            }
            for (int j = mat[0].length - i - 1; j > i; j--) {
                l.add(mat[mat.length - i - 1][j]);
            }
            for (int j = mat.length - i - 1; j > i; j--) {
                l.add(mat[j][i]);
            }
            Collections.rotate(l, mag);
            for (int j = i; j < mat.length - i - 1; j++) {
                mat[i][j] = l.remove(0);
            }
            for (int j = i; j < mat.length - i - 1; j++) {
                mat[j][mat[0].length - i - 1] = l.remove(0);
            }
            for (int j = mat[0].length - i - 1; j > i; j--) {
                mat[mat.length - i - 1][j] = l.remove(0);
            }
            for (int j = mat.length - i - 1; j > i; j--) {
                mat[j][i] = l.remove(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new trap().run();
    }

}