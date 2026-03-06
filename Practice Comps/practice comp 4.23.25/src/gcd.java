import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class gcd{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gcd".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            int times2=f.nextInt(); f.nextLine();
            BigInteger[] bi = new BigInteger[times2];
            for (int i = 0; i < times2; i++) {
                bi[i] = f.nextBigInteger();
            }
            BigInteger a = bi[0];
            for (int i = 1; i < times2; i++) {
                a = a.gcd(bi[i]);
            }
            System.out.println(a);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new gcd().run();
    }
}
