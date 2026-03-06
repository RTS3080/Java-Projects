import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class orbit{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        ArrayList<BigInteger> nums = new ArrayList<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            nums.add(new BigInteger(f.next()));
        }
        BigInteger gcd = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            gcd = (gcd.multiply(nums.get(i))).divide(gcd.gcd(nums.get(i)));
        }
        System.out.println(gcd);
        for(BigInteger i : nums){
            System.out.print(gcd.divide(i)+" ");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new orbit().run();
    }
}
