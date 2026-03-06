import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class jennifer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jennifer".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            BigInteger d = f.nextBigInteger();
            BigInteger n = f.nextBigInteger();
            BigInteger gcd=n.gcd(d);
            n = n.divide(gcd);
            d = d.divide(gcd);
            n = n.subtract(d);
            System.out.println(n+" "+d);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jennifer().run();
    }
}
