import java.util.*;
import java.io.*;

public class shirley{
    int[][] mat;
    int steps;
    long sum;

    public void recur(int r, int c) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] <= 0) {
            return;
        }

        steps++;
        sum += mat[r][c];
        mat[r][c] = 0;
        recur(r - 1, c);
        recur(r + 1, c);
        recur(r, c - 1);
        recur(r, c + 1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shirley".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        for (int ca = 1; ca <= times; ca++) {
            int rows = f.nextInt(); int cols = f.nextInt();
            mat = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = f.nextInt();
                    if (mat[i][j] < 250) mat[i][j] = 0;
                }
            }

            steps = 0;
            sum = 0;

            ArrayList<long[]> results = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] > 0) {
                        steps = 0;
                        sum = 0;
                        recur(i, j);

                        if (steps >= 2)
                            results.add(new long[] {sum, steps});
                    }
                }
            }

            results.sort((a, b) -> {
                if (a[0] == b[0]) return (int) (b[1] - a[1]);
                return (int) (b[0] - a[0]);
            });

            System.out.println("Case #" + ca + ":");
            for (int i = 0; i < 3; i++) {
                if (i >= results.size()) {
                    System.out.println("NONE");
                } else {
                    System.out.printf("%d %.1f%n", results.get(i)[0], (double) results.get(i)[1] / rows / cols * 100.0);
                }
            }
            System.out.println("^".repeat(12));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shirley().run();
    }
}
