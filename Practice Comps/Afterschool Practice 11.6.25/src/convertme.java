import java.util.*;
import java.io.*;
import java.awt.*;

public class convertme{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("convertme".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int initial = f.nextInt();
            int target = f.nextInt();

            int[] dp = new int[target+1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            if (initial >= target){
                System.out.println("-1");
                continue;
            }

            dp[initial] = 0;

            for (int i = initial; i <= target; i++){
                if (dp[i] == Integer.MAX_VALUE) continue;

                for (int j = 2; j < i; j++){
                    if (i % j == 0 && i+j <= target){
                        dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                    }
                }
            }

            if (dp[target] == Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(dp[target]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new convertme().run();
    }
}
