import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rooks{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rooks".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger b = f.nextBigInteger();
            BigInteger out = BigInteger.ONE;
            while(b.compareTo(BigInteger.ZERO)>0){
                out = out.multiply(b);
                b = b.subtract(BigInteger.ONE);
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rooks().run();
    }
}
