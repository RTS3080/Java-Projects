import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class cancer{
    int res;

    public char[][] copy(char[][] mat) {
        char[][] copy = new char[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            copy[i] = mat[i].clone();
        }

        return copy;
    }

    public boolean isFree(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == '#') return false;
            }
        } return true;
    }

    public String toString(char[][] mat) {
        String res = "";
        for (char[] row : mat) {
            res += new String(row);
        } return res;
    }

    public boolean inBounds(char[][] mat, int r, int c) {
        return r >= 0 && c >= 0 && r < mat.length && c < mat[r].length;
    }

    public int countInfected(char[][] mat, int r, int c) {
        int count = 0;

        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                if (i == r && c == j || !inBounds(mat, i, j)) continue;
                if (mat[i][j] == '#' || mat[i][j] == '@') count++;
            }
        }
        return count;
    }

    public char[][] next(char[][] mat) {
        char[][] copy = copy(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int infected = countInfected(mat, i, j);

                if (mat[i][j] == '#') {
                    if (infected != 2 && infected != 3) {
                        copy[i][j] = '.';
                    } else {
                        copy[i][j] = '#';
                    }
                } else {
                    if (infected == 3) {
                        copy[i][j] = '#';
                    } else {
                        copy[i][j] = '.';
                    }
                }
            }
        } return copy;
    }

    public boolean dfs(char[][] mat, int time, int r, int c, HashMap<String, Integer> vis) {
        if (isFree(mat)) return true;

        String str = toString(mat);

        if (vis.containsKey(str) && time >= vis.get(str)) return false;
        vis.put(str, time);
        if (!inBounds(mat, r, c)) return false;


        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        boolean res = false;

        char[][] nextMat = next(mat);
        nextMat[r][c] = '.';

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (!inBounds(nextMat, nr, nc)) continue;
            if (nextMat[nr][nc] == '#') continue;

            nextMat[nr][nc] = '@';
            res |= dfs(nextMat, time + 1, nr, nc, vis);
            nextMat[nr][nc] = '.';
        }

        nextMat[r][c] = '@';
        return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cancer".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            res = Integer.MAX_VALUE;

            char[][] mat = new char[N][N];

            int sr = -1, sc = -1;

            for (int i = 0; i < N; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (mat[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            if (isFree(mat)) {
                System.out.println(0);
                continue;
            }

            boolean isFreeable = dfs(mat, 0, sr, sc, new HashMap<>());

            if (isFreeable) {
                System.out.println(res);
            } else {
                System.out.println(-1);
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cancer().run();
    }
}
