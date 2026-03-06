import java.util.*;
import java.io.*;
import java.awt.*;

public class pamela{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pamela".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        for (int casen = 1; casen <= times; casen++){
            int r = f.nextInt();
            int c = f.nextInt();
            f.nextLine();

            int[][] mat = new int[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }

            int[] rowmins = new int[r];
            int[] rowsums = new int[r];
            int[] colmins = new int[c];
            int[] colsums = new int[c];

            Arrays.fill(rowmins, Integer.MAX_VALUE);
            Arrays.fill(colmins, Integer.MIN_VALUE);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rowmins[i] = Math.min(rowmins[i], mat[i][j]);
                    rowsums[i] += mat[i][j];

                    colmins[j] = Math.max(colmins[j], mat[i][j]);
                    colsums[j] += mat[i][j];

                    min = Math.min(min, rowmins[i]);
                    max = Math.max(max, mat[i][j]);
                }
            }

            System.out.println("Case: " + casen);
            System.out.print("Row Sums:");
            for (int n : rowsums) {
                System.out.printf("%7d", n);
            }
            System.out.print("\nRow Mins:");
            for (int n : rowmins) {
                System.out.printf("%7d", n);
            }
            System.out.print("\nCol Sums:");
            for (int n : colsums) {
                System.out.printf("%7d", n);
            }
            System.out.print("\nCol Maxs:");
            for (int n : colmins) {
                System.out.printf("%7d", n);
            }
            System.out.print("\nMin Mins:");
            System.out.printf("%7d%n", min);
            System.out.print("Max Maxs:");
            System.out.printf("%7d%n", max);
            System.out.println("=".repeat(20));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pamela().run();
    }
}
