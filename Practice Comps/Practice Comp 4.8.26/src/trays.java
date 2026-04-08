import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class trays{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("trays".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int units = f.nextInt();
            int rows = f.nextInt();
            int cols = f.nextInt();
            double[][] triangle = new double[rows+1][];
            for (int i = 0; i < triangle.length; i++) {
                triangle[i] = new double[i+1];
            }
            triangle[0][0] = units;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if(triangle[i][j] >1){
                        double extra = triangle[i][j] -1;
                        triangle[i+1][j] += extra/2;
                        triangle[i+1][j+1] +=extra/2;
                    }
                }
            }
//            for (int i = 0; i < triangle.length; i++) {
//               System.out.println(Arrays.toString(triangle[i]));
//            }
            System.out.printf("%.2f\n", triangle[rows-1][cols-1]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new trays().run();
    }
}
