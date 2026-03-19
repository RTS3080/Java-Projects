import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class max{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("max".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int cases = f.nextInt();
        while (cases-- > 0){
            int numGames = f.nextInt();
            int totalTime = f.nextInt();

            int[] times = new int[numGames];
            for (int i = 0; i < numGames; i++) times[i] = f.nextInt();

            int[] enjoys = new int[numGames];
            for (int i = 0; i < numGames; i++) enjoys[i] = (int) (f.nextDouble() * 100);

            int[][] dp = new int[numGames+1][totalTime+1];
            int result = 0;

            for (int r = 1; r < dp.length; r++){
                for (int c = 0; c < dp[r].length; c++){
                    dp[r][c] = dp[r-1][c];
                    int ind = r-1;
                    if (c - times[ind] >= 0){
                        dp[r][c] = Math.max(dp[r][c], enjoys[ind] + dp[r][c-times[ind]]);
                    }
                    result = Math.max(result, dp[r][c]);
                }
            }

//            for (int[] each : dp) System.out.println(Arrays.toString(each));

            if (result == 0.0) System.out.println("Should have picked better games...");
            else System.out.printf("%.2f\n", result/100.0);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new max().run();
    }
}
