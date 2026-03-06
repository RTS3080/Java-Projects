import java.util.*;
import java.io.*;

public class colette{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("colette".toLowerCase()+".in"));

        int cases = f.nextInt();
        while (cases-- > 0){
            X = f.nextInt();
            A = f.nextInt();
            Y = f.nextInt();
            B = f.nextInt();

            dp = new int[10_001];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            System.out.println(recur(10_000));
        }

        f.close();
    }

    int X, A, Y, B;
    int[] dp;

    public int recur(int check){
        if (check <= 0) return 0;
        if (dp[check] != Integer.MAX_VALUE) return dp[check];

        int temp = Integer.MAX_VALUE;

        int numSubtract = (int) Math.floor(check * (X / 100.));

        if (numSubtract != 0) {
            int usingNormal = recur(check - numSubtract) + A;
            temp = Math.min(temp, usingNormal);
        }

        numSubtract = (int) Math.floor(10_000 * (Y / 100.));
        if (numSubtract != 0) {
            int usingSpecial = recur(check - numSubtract) + B;
            temp = Math.min(temp, usingSpecial);
        }

        return dp[check] = temp;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new colette().run();
    }
}
