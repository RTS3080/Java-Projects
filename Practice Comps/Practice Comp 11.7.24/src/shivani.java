import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class shivani{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shivani".toLowerCase()+".dat"));
        long times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger n = f.nextBigInteger();
            BigInteger tot = BigInteger.ZERO;
            for(BigInteger i = BigInteger.ONE; i.compareTo(n)<=0; i=i.add(BigInteger.ONE)){
                tot = tot.add(i.pow(i.intValue()-1));
            }
            System.out.println(tot);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shivani().run();
    }
}
