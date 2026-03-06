import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class prob09{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob09".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long[] ln = Arrays.stream(f.nextLine().split(",")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(ln);
            BigInteger totgcd = BigInteger.ONE;

            while(ln[1]-ln[0]>0){
                BigInteger a = new BigInteger(ln[1]+"");
                BigInteger b = new BigInteger(ln[0]+"");
                BigInteger c = a.gcd(b);
                BigInteger d = a.subtract(b);
                totgcd = totgcd.multiply(c);
                System.out.println(a+"-"+b+"="+d);
                ln[1] = Math.max(b.longValue(),d.longValue());
                ln[0] = Math.min(b.longValue(), d.longValue());
            }
            System.out.println(ln[0]+"-"+ln[1]+"="+(ln[1]-ln[0]));
            if(totgcd.compareTo(BigInteger.ONE)==0){
                System.out.println("COPRIME");
            }
            else{
                System.out.println("NOT COPRIME");
            }

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob09().run();
    }
}
