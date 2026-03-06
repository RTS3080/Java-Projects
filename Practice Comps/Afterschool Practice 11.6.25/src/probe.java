import java.util.*;
import java.io.*;
import java.awt.*;

public class probe{
    public int[][] copy(int[][] mat) {
        int[][] copy = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                copy[i][j] = mat[i][j];
            }
        } return copy;
    }

    public int count(int[][] mat, int i, int j, int k, int l) {
        int count = 0;
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (r < 0 || r >= mat.length || c < 0 || c >= mat.length) continue;
                count += mat[r][c];
                mat[r][c] = 0;
            }
        }

        for (int r = k - 1; r <= k + 1; r++) {
            for (int c = l - 1; c <= l + 1; c++) {
                if (r < 0 || r >= mat.length || c < 0 || c >= mat.length) continue;
                count += mat[r][c];
                mat[r][c] = 0;
            }
        }

        return count;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("probe".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int size = f.nextInt();
            f.nextLine();
            int[][] mat = new int[size][size];
            for (int i = 0; i < mat.length; i++) {
                mat[i] = Arrays.stream(f.nextLine().trim().split(" +")).mapToInt(Integer::parseInt).toArray();
            }

            int res = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            res = Math.max(res, count(copy(mat), i, j, k, l));
                        }
                    }
                }
            }

            System.out.println(res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new probe().run();
    }
}
