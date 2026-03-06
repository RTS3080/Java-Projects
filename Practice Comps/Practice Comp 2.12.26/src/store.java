import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class store{


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("store".toLowerCase()+".dat"));
        vals = new int[]{100,25,10,5,1};

        int cases = f.nextInt();
        while (cases-- > 0) {
            N = f.nextInt();

            int[] coins = new int[5];
            for (int i = 0; i < 5; i++)coins[i] = f.nextInt();

            prices = new int[N];
            for (int i = 0; i < N; i++){
                f.next();
                prices[i] = (int) (f.nextDouble()*100);
            }

            madeOne = false;

            boolean result = recur(0, coins, 0, 0);



            if (result){
                System.out.println("Got all items");
            }
            else{
                for (int i = 1; i < N; i++){
                    result |= recur(i, coins, 0, 0);
                }
                if (madeOne){
                    System.out.println("Come again");
                }
                else {
                    System.out.println("Mission failed");
                }
            }
//            System.out.println("=".repeat(100));
        }
        f.close();
    }


    int N;
    boolean madeOne;

    int[] vals;
    int[] prices;

    public boolean recur(int priceInd, int[] coins, int coinInd, int cur){
//
//        System.out.println(priceInd);
//        System.out.println(Arrays.toString(coins));
//        System.out.println(coinInd);
//        System.out.println(cur);
//        System.out.println("-".repeat(10));
        if (priceInd == N) return true;
        if (cur == prices[priceInd]){
            madeOne = true;
            return recur(priceInd+1, coins, 0, 0);
        }

        if (cur > prices[priceInd]) return false;
        if (coinInd >= 4) return false;

        boolean result = false;
        if (coins[coinInd] > 0){
            coins[coinInd]--;

            result = recur(priceInd, coins, coinInd, cur+vals[coinInd]);
            if (result) return true;

            result = recur(priceInd, coins, coinInd+1, cur+vals[coinInd]);
            if (result) return true;

            coins[coinInd]++;
        }

        result = recur(priceInd, coins, coinInd+1, cur);
        if (result) return true;

        return false;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new store().run();
    }
}
