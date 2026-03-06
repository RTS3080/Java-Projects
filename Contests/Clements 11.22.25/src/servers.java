import java.util.*;
import java.io.*;
import java.awt.*;

public class servers{
    long[][] mat;
    long[][] dp;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("servers".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows=f.nextInt(); int cols=f.nextInt(); f.nextLine();
            mat = new long[rows][cols];
            dp = new long[rows][cols];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(dp[i], Long.MAX_VALUE);
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = f.nextLong();
                }
            }

            dp[0][0] = mat[0][0];
            for (int i = 1; i < rows; i++) {
                dp[i][0] = mat[i][0] + dp[i - 1][0];
            }

            for (int i = 1; i < cols; i++) {
                dp[0][i] = mat[0][i] + dp[0][i - 1];
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j] = mat[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            System.out.println(dp[rows-1][cols-1]);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new servers().run();
    }
}
