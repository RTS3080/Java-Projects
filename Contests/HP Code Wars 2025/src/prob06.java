import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class prob06{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        BigInteger n = f.nextBigInteger();
        ArrayList<BigInteger> bigs = new ArrayList();
        BigInteger start = BigInteger.TWO;
        while(start.compareTo(n.divide(BigInteger.TWO))<=0){
            if(n.mod(start) == BigInteger.ZERO){
                if(!bigs.contains(n) && !bigs.contains(n.divide(start))){
                    bigs.add(start);
                }
            }
            start = start.add(BigInteger.ONE);
        }
        for(BigInteger b : bigs){
            System.out.println(n.divide(b)+" x "+b);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob06().run();
    }
}
