import java.util.*;
import java.io.*;

public class coinsRemainder{
    int[] coins;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("coinsRemainder".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n=f.nextInt();
            int len = f.nextInt();
            coins = new int[len];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = f.nextInt();
            }
            System.out.println(count(len,n));
//            System.out.println(recur(a,n));
        }
        f.close();
    }
    int count(int n, int sum)
    {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0)
            return 1;

        // If sum is less than 0 then no
        // solution exists
        if (sum < 0)
            return 0;

        // If there are no coins and sum
        // is greater than 0, then no
        // solution exist
        if (n <= 0)
            return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return count(n - 1, sum)
                + count(n, sum - coins[n - 1]);
    }

    
    
    public static void main(String[] args) throws FileNotFoundException{
        new coinsRemainder().run();
    }
}
