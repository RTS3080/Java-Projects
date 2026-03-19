import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class dilbert{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dilbert".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int times = 0;

        while (f.hasNext()){
            BigInteger num = new BigInteger(f.next());
            String bits = num.toString(2);
            String rev = new StringBuffer(bits).reverse().toString();
            BigInteger revNum = new BigInteger(rev, 2);
            System.out.println("Test Case: " + ++times + ": " + revNum + " " + revNum.toString(2));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dilbert().run();
    }
}
