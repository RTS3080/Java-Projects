import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class terry{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("terry".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int N = f.nextInt();
            int target = f.nextInt();

            int[] values = new int[N];
            double[] catches = new double[N];

            int total = 0;

            for (int i = 0; i < N; i++){
                values[i] = f.nextInt();
                total += values[i];
                catches[i] = f.nextInt()/100.0;
            }


//            System.out.println(Arrays.toString(values));
//            System.out.println(Arrays.toString(catches));

            double[][] dp = new double[N+1][total+1];

            for (double[] each : dp) Arrays.fill(each, 1);

            dp[0][0] = 0;
//            Arrays.fill(dp[0], 0.0);

//            for (double[] each : dp) System.out.println(Arrays.toString(each));

            double result = 1.0;

            for (int r = 1 ; r < dp.length ; r++){
                for (int c = 0 ; c < dp[r].length ; c++){
                    dp[r][c] = dp[r-1][c];
                    if (c-values[r-1] >= 0){
                        double check = dp[r-1][c-values[r-1]];
                        check = check + (1.0 - check) * catches[r-1];
                        dp[r][c] = Math.min(dp[r][c], check);

//                        System.out.println(r+" "+c);

                    }
                    if (c >= target) result = Math.min(result, dp[r][c]);
                }
//                System.out.println(Arrays.toString(dp[r]));
            }

            System.out.printf("Case #%d: %.6f\n", CASE, result*100);

//            System.out.println(result);
//            for (double[] each : dp) System.out.println(Arrays.toString(each));

//            System.out.println(dp[N][target]);

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new terry().run();
    }
}
