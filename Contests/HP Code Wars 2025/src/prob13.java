import java.math.*;
import java.util.*;
import java.io.*;

public class prob13{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        while(f.hasNext()){
            String s = f.nextLine().trim();
            if(s.equals("0 0")) break;
            String[] ln = s.split(" ");
            BigInteger n = new BigInteger(ln[0]);
            BigInteger d = new BigInteger(ln[1]);
            BigInteger gcd = n.gcd(d);
            n = n.divide(gcd);
            d = d.divide(gcd);
            BigInteger a= BigInteger.ZERO;
            if(n.compareTo(d)>=0){
                a=n.divide(d);
                n = n.mod(d);
            }
            String str = "";
            if (a.compareTo(BigInteger.ZERO) !=0){
                str+=(a+" ");
                if(n.compareTo(BigInteger.ZERO)!=0){
                    str+=(n+"/"+d);
                }
            }
            else if(n.compareTo(BigInteger.ZERO)==0){
                str+=("0");
            }
            else str+=(n+"/"+d);
            System.out.println(str.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob13().run();
    }
}
