import java.util.*;
import java.io.*;

public class coins{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("coins".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int nCoins = f.nextInt();
            int cost = f.nextInt();
            boolean[] dp = new boolean[cost+1];
            dp[0] = true;
            int[] coins = new int[nCoins];
            for (int i = 0; i < nCoins; i++) {
                coins[i]=f.nextInt();
            }

            for(int i : coins){
                for (int j = dp.length-1; j-i>=0;j--) {
                    if(dp[j-i])
                        dp[j] = true;
                }
            }
            System.out.println(dp[cost]);
        }
        f.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        new coins().run();
    }
}
