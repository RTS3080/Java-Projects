import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Jennifer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Jennifer".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n1 = f.nextInt();
            int d1  = f.nextInt();
            BigInteger n = new BigInteger(""+n1);
            BigInteger d = new BigInteger(""+d1);
            BigInteger gcd = n.gcd(d);
            n=n.divide(gcd);
            d = d.divide(gcd);
//            n=n.subtract(d);
            d = d.subtract(n);
            System.out.println(d+" "+n);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Jennifer().run();
    }
}
