import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class lucky{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lucky".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0){
            String[] line = f.nextLine().trim().split("\\s+");
            int[] arr = new int[line.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(line[i]);

            int totalSum = 0;
            for (int each : arr) totalSum += each;

            int[][] dp = new int[arr.length+2][arr.length+2];
            for (int i = 1; i <= arr.length; i++) dp[i][i] = arr[i-1];

            for (int r = 2; r <= arr.length; r++){
                for (int c = r-1; c >= 1; c--){
//                    for (int[] each:dp) System.out.println(Arrays.toString(each));
                    int max = 0;
                    max = Math.max(max,
                            arr[r-1] + Math.min(dp[r-1][c+1], dp[r-2][c]));
                    max = Math.max(max,
                            arr[c-1] + Math.min(dp[r-1][c+1], dp[r][c+2]));

                    dp[r][c] = max;
                }
            }

//            for (int[] each : dp) System.out.println(Arrays.toString(each));

            int myScore = dp[arr.length][1];
            int enemyScore = totalSum-myScore;

            if (myScore <= enemyScore) System.out.println("Scams R Us.");
            else System.out.println("Those are my Lucky Charms: "+myScore);
//            System.out.println(myScore);
//
//            System.out.println("-".repeat(arr.length));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lucky().run();
    }
}
