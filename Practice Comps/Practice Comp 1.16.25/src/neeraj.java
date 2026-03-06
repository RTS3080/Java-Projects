import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class neeraj{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("neeraj".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            double a = f.nextDouble();
            double d = Math.pow(10,(""+a).length()-2);
            double n = a*d;
            BigInteger num = new BigInteger(String.valueOf((int)n));
            BigInteger denom = new BigInteger(String.valueOf((int)d));

            BigInteger gcd = num.gcd(denom);

            num = num.divide(gcd);
            denom = denom.divide(gcd);
            String s = a+"";

            System.out.print(s.substring(1)+" is equal to "+num+"/"+denom+"\n");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new neeraj().run();
    }
}
