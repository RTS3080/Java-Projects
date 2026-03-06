import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rahul{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rahul".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();
        while(cases-->0){
            String[] line = f.nextLine().trim().split("\\s+");

            int[] arr = new int[line.length];
            for (int i = 0; i < line.length; i++){
                arr[i] = Integer.parseInt(line[i]);
            }

            int[][] dp = new int[line.length][2];
            dp[0][0] = dp[0][1] = 1;
            for (int i = 0; i < line.length; i++){
                int state0Max = 1;
                int state1Max = 1;
                for (int j = 0; j < i; j++){
                    if (arr[j] < arr[i]){
                        state0Max = Math.max(state0Max, dp[j][1]+1);
                    }
                    if (arr[j] > arr[i]){
                        state1Max = Math.max(state1Max, dp[j][0]+1);
                    }
                }
                dp[i][0] = state0Max;
                dp[i][1] = state1Max;
            }

            System.out.println(Math.max(dp[line.length-1][0], dp[line.length-1][1]));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rahul().run();
    }
}
