import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class diana{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diana".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        long[] dp = new long[(int)(5E9)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2]+dp[i-3])%((int)(1E9+7));
        }
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            System.out.println(dp[f.nextInt()]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new diana().run();
    }
}
