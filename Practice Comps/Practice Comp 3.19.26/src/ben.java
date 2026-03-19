import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ben{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ben".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        long MOD = (long) (1e9+7);
        String pidgeon = "pidgeon";
        int cases = f.nextInt();
        while (cases-- > 0){
            String check = f.next();
            long[] dp = new long[pidgeon.length()+1];
            dp[0] = 1;
            for (char each : check.toCharArray()){
                int ind = pidgeon.indexOf(each);
                dp[ind+1] = (dp[ind+1] + dp[ind]) % MOD;
            }
            System.out.println(dp[pidgeon.length()]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ben().run();
    }
}
