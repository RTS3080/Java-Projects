import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class fraction{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fraction".toLowerCase()+".dat"));
        while(f.hasNext()){
            BigInteger num = f.nextBigInteger();
            BigInteger denom = f.nextBigInteger();
            BigInteger gcd = num.gcd(denom);
            num = num.divide(gcd);
            denom = denom.divide(gcd);
            System.out.println(num+" "+denom);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fraction().run();
    }
}
