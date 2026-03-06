import java.util.*;
import java.io.*;

public class juana{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("juana".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        for (int z = 0; z < times; z++) {
            System.out.printf("Test Case #%d:", z + 1);

            int rows = f.nextInt();
            int cols = f.nextInt();

            int[][] mat = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = f.nextInt();
                }
            }

            boolean isValid = true;
            int sr = f.nextInt() - 1, sc = f.nextInt() - 1;
            cols = f.nextInt();
            rows = f.nextInt();
            long[][] chunk = new long[rows][cols];

            for (int i = sr; i < sr + rows; i++) {
                for (int j = sc; j < sc + cols; j++) {
                    if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
                        isValid = false;
                        break;
                    } chunk[i - sr][j - sc] = mat[i][j];
                }
            }

            if (!isValid) {
                System.out.println(" Unable to extract requested size!");
            } else {
                System.out.println();
                for (long[] row : chunk) {
                    for (long item : row) {
                        System.out.printf("%5d", item);
                    }
                    System.out.println();
                }
            }
            System.out.println("-".repeat(20));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new juana().run();
    }
}
