import java.util.*;
import java.io.*;

public class shreya{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shreya".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] strs = f.nextLine().trim().split("\\s+");
            int[] coins = new int[strs.length];
            for(int i = 0; i < strs.length; i++){
                coins[i] = Integer.parseInt(strs[i]);
            }
            int target = f.nextInt();
            f.nextLine();
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int coin : coins) {
                for (int i = target; i > 0; i--) {
                    if (i - coin < 0) break;
                    dp[i] |= dp[i - coin];
                }
            }

            System.out.println(dp[target] ? "Business as usual." : "Dine and Dash.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shreya().run();
    }
}
