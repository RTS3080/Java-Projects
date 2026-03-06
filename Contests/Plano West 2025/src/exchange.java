import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class exchange{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        BigDecimal num = new BigDecimal("7552701074431167");
        BigDecimal n = f.nextBigDecimal();
        BigInteger sum = BigInteger.ZERO;
        String s = n.toString();
        for (int i = 0; i < s.length(); i++) {
            BigDecimal d = new BigDecimal(s.substring(i,i+1)).multiply(new BigDecimal((int)Math.pow(10,s.length()-1-i)+""));
//            System.out.println(d);
            BigDecimal perc = new BigDecimal((Math.pow(.8, i))+"");
//            System.out.println(perc);
//            System.out.println(d.multiply(perc).multiply(num));
            BigInteger HAHAHA = new BigInteger((d.multiply(perc).multiply(num).longValue())+"");
//            System.out.println(HAHAHA);
            sum=sum.add(HAHAHA);
        }
        System.out.println(sum.toString());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new exchange().run();
    }
}
