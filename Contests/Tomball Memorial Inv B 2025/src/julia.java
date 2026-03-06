import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class julia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("julia".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger n = BigInteger.TWO;
            BigInteger end = f.nextBigInteger();
            int count = 0;
            while(end.compareTo(n)>0){
                count++;
                n = n.nextProbablePrime();
            }
            System.out.println(count);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new julia().run();
    }
}
