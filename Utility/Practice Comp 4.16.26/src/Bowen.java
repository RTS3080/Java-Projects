import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Bowen{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bowen".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int a = f.nextInt();
            BigInteger b = BigInteger.ONE.shiftLeft(a).subtract(BigInteger.ONE);
            System.out.println(b);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bowen().run();
    }
}
