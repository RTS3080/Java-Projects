import java.util.*;
import java.io.*;

public class Sunil{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Sunil".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            double[][] mat = new double[rows][cols];
            double tot = 0.0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = f.nextDouble();
                    tot += mat[i][j];
                }
            }

            for (int r = 0; r < rows; r++) {
                double sum = 0;
                for (int c = 0; c < cols; c++) {
                    sum += mat[r][c];
                }
                System.out.printf("%8.2f", sum/cols);
            }
            System.out.println();

            for (int c = 0; c < cols; c++) {
                double sum = 0;
                for (int r = 0; r < rows; r++) {
                    sum += mat[r][c];
                }
                System.out.printf("%8.2f", sum/rows);
            }
            System.out.println();
            System.out.printf("%8.2f%n", tot / rows / cols);
            System.out.println("=".repeat(25));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Sunil().run();
    }
}
