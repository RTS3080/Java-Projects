import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class pamela{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pamela".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            int absMin = Integer.MAX_VALUE;
            int absMax = Integer.MIN_VALUE;
            int[] rowSums = new int[r];
            int[] rowMins = new int[r];
            int[] colSums = new int[c];
            int[] colMaxs = new int[c];
            int[][] mat = new int[r][c];
            for (int i = 0; i < r; i++) {
                int sum = 0;
                int curMin = Integer.MAX_VALUE;
                for (int j = 0; j < c; j++) {
                    mat[i][j] = f.nextInt();
                    sum+=mat[i][j];
                    curMin = Math.min(curMin, mat[i][j]);
                }
                rowSums[i] = sum;
                rowMins[i] = curMin;
                absMin = Math.min(absMin, curMin);
            }
            for (int i = 0; i < c; i++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < r; j++) {
                    sum+=mat[j][i];
                    max = Math.max(max, mat[j][i]);
                }
                colSums[i] = sum;
                colMaxs[i] = max;
                absMax = Math.max(absMax, max);
            }
            System.out.println("Case: "+times);
            System.out.print("Row Sums:");
            for (int i = 0; i < r; i++) {
                System.out.printf("%7d", rowSums[i]);
            }
            System.out.println();
            System.out.print("Row Mins:");
            for (int i = 0; i < r; i++) {
                System.out.printf("%7d", rowMins[i]);
            }
            System.out.println();
            System.out.print("Col Sums:");
            for (int i = 0; i < c; i++) {
                System.out.printf("%7d", colSums[i]);
            }
            System.out.println();
            System.out.print("Col Maxs:");
            for (int i = 0; i < c; i++) {
                System.out.printf("%7d", colMaxs[i]);
            }
            System.out.println();
            System.out.printf("Min Mins:%7d\n", absMin);
            System.out.printf("Max Maxs:%7d\n", absMax);
            System.out.println("=".repeat(20));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pamela().run();
    }
}
