import java.math.*;
import java.util.*;
import java.io.*;
import java.awt.*;

public class diamonds{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diamonds".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger max = BigInteger.valueOf(Long.MIN_VALUE);
            String[] ln = f.nextLine().split(" ");
            for(String s : ln){
                BigInteger b = new BigInteger(s);
                max = max.max(b);
            }
            System.out.println(max) ;
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new diamonds().run();
    }
}
