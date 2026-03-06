import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Dante{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Dante".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger start=f.nextBigInteger();
            BigInteger end=f.nextBigInteger();
            int count = 0;
            while(end.compareTo(start)>0){
                start = start.nextProbablePrime();
                count++;
            }
            System.out.println(count-1);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Dante().run();
    }
}
