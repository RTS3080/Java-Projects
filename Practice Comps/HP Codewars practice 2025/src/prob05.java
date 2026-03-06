import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class prob05{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob05".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            String s = f.nextLine().trim();
            BigInteger num = new BigInteger(s);
            int count = 1;
            while (num.compareTo(BigInteger.ONE) > 0) {
                count++;
                if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                    num = num.divide(BigInteger.valueOf(2));
                } else {
                    num = num.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
                }
            }
            System.out.println(s + ":" + count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob05().run();
    }
}
