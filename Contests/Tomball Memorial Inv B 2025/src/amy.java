import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class amy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("amy".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len = f.next().length();
            BigInteger rate = f.nextBigInteger();
            BigInteger n = BigInteger.valueOf(36);
            BigInteger l = BigInteger.valueOf(len);
            System.out.println((n.pow(len).divide(rate)));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new amy().run();
    }
}
