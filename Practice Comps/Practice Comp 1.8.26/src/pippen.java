import java.util.*;
import java.io.*;
import java.awt.*;

public class pippen{
    char[][] mat;
    int[][][][] shad;
    String keyString;

    public String printKeys(int k) {
        String str = "000000000000000000000000000000000000000000000" + Integer.toString(k, 2);
        return str.substring(str.length() - keyString.length());
    }

    public int dfs(int r, int c, int k, int diags, int steps) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length) return Integer.MAX_VALUE;
        if (mat[r][c] == '#') return Integer.MAX_VALUE;
        if (shad[k][diags][r][c] <= steps) return Integer.MAX_VALUE;

        System.out.println(mat[r][c] + " " + r + " " + c + " " + printKeys(k) + " " + diags + " " + steps);

        if (Character.isUpperCase(mat[r][c])) {
            int idx = keyString.indexOf((char) (mat[r][c] + 32) + "");
            if (idx == -1) return Integer.MAX_VALUE;
            if ((1 << idx & k) == 0) return Integer.MAX_VALUE;
        }

        shad[k][diags][r][c] = steps;

        if (Character.isLowerCase(mat[r][c])) {
            int idx = keyString.indexOf((char) (mat[r][c]) + "");
            k |= 1 << idx;
            if (shad[k][diags][r][c] <= steps) return Integer.MAX_VALUE;
            shad[k][diags][r][c] = steps;
        }

        if (mat[r][c] == '[') return steps;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            res = Math.min(res, dfs(nr, nc, k, diags, steps + 1));
        }

        if (diags > 0) {
            dirs = new int[][]{{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                res = Math.min(res, dfs(nr, nc, k, diags - 1, steps + 1));
            }
        } return res;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pippen".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            int diagSteps = f.nextInt(); f.nextLine();

            keyString = "";
            mat = new char[rows][cols];

            int sr = -1, sc = -1;

            for (int i = 0; i < rows; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == ']') {
                        sr = i;
                        sc = j;
                    }

                    if (Character.isLetter(mat[i][j]) && Character.isLowerCase(mat[i][j])) {
                        keyString += mat[i][j];
                    }
                }
            }

            shad = new int[1 << keyString.length()][diagSteps + 1][rows][cols];
            for (int i = 0; i < shad.length; i++) {
                for (int j = 0; j < shad[i].length; j++) {
                    for (int k = 0; k < shad[i][j].length; k++) {
                        Arrays.fill(shad[i][j][k], Integer.MAX_VALUE);
                    }
                }
            }


            char[] chs = keyString.toCharArray();
            Arrays.sort(chs);
            StringBuilder sb = new StringBuilder(keyString);
            keyString = sb.reverse().toString();
            System.out.println(keyString);

            int res = dfs(sr, sc, 0, diagSteps, 0);
            if (res == Integer.MAX_VALUE) {
                System.out.println("Failed :(");
            } else {
                System.out.println("Success in " + res + " step(s).");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pippen().run();
    }
}
