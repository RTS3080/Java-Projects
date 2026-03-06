import java.util.*;
import java.io.*;

public class theft {


    public void run() throws Exception {
        Scanner f = new Scanner(new File("theft".toLowerCase() + ".dat"));

        int N = f.nextInt();
        while(N-- > 0){
            int maxCap = f.nextInt();
            int numItems = f.nextInt();

            int[] weights = new int[numItems];
            for (int i = 0; i < numItems; i++) weights[i] = f.nextInt();

            int[] profits = new int[numItems];
            for (int i = 0; i < numItems; i++) profits[i] = f.nextInt();
            f.nextLine();

            String[] names = f.nextLine().split("(, )+");

            int[][] dp = new int[numItems+1][maxCap+1];
            String[][] used = new String[numItems+1][maxCap+1];
            for (String[] each:used) Arrays.fill(each, "");

            for (int r = 1; r < numItems+1; r++){
                for (int c = 1; c < maxCap+1; c++){
                    dp[r][c] = dp[r-1][c];
                    used[r][c] = used[r-1][c];

                    if (c-weights[r-1] >= 0 && dp[r][c] < dp[r-1][c-weights[r-1]]+profits[r-1]){
                        dp[r][c] = dp[r-1][c-weights[r-1]]+profits[r-1];
                        used[r][c] = used[r-1][c-weights[r-1]]+names[r-1]+",";
                    }
                }
            }

            System.out.println("Max Capacity: "+maxCap);
            System.out.println("Max Profit: $"+dp[numItems][maxCap]);

            if (used[numItems][maxCap].equals("")){
                System.out.println("Nothing could be stolen...");
                System.out.println();
                continue;
            }

            String[] finalUsed = used[numItems][maxCap].split(",");

            for (String each : finalUsed) {
                System.out.println(each);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new theft().run();
    }
}