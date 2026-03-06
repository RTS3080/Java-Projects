import com.sun.security.jgss.GSSUtil;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;

public class sammy{

    public void run() throws FileNotFoundException{
        BigInteger mod = new BigInteger("1000000007");

        Scanner f= new Scanner(new File("sammy".toLowerCase()+".in"));
        String[] ln = f.nextLine().split(" ");
        BigInteger[] nums = new BigInteger[ln.length];
        for (int i = 0; i < ln.length; i++) {
            nums[i] = BigInteger.valueOf(Long.parseLong(ln[i]));
        }
        BigInteger[] prefix = new BigInteger[nums.length];

        BigInteger temp = BigInteger.ONE;
        for (int i = 0; i < nums.length; i++) {
            temp = temp.multiply(nums[i]);
            prefix[i] = temp;
        }


        while (f.hasNext()){
            int start = f.nextInt();
            int end = f.nextInt();

            BigInteger result = prefix[end].divide(((start-1) >= 0 ? prefix[start-1] : BigInteger.ONE));
            result = result.mod(mod);
            System.out.println(result);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sammy().run();
    }
}
