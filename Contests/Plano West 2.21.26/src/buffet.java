import java.math.BigInteger;
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class buffet{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("buffet".toLowerCase()+".in"));

        int A = f.nextInt();
        int B = f.nextInt();
        int N = f.nextInt();
        loop:
        while(N-->0){
            int sum = f.nextInt();
            int count = 0;
            int[] coins;
            if(A==B){
                coins = new int[1];
                coins[0] = A;
            }
            else{
                coins = new int[2];
                coins[0] = A;
                coins[1] = B;
            }



            System.out.println(count);
        }

        f.close();
    }
    BigInteger factorial(int n){
        BigInteger f = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new buffet().run();
    }
}
