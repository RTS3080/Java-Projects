import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;

public class ones{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ones".toLowerCase()+".dat"));
        String ln[] = f.nextLine().trim().split("\\s+");
        for(String s : ln){
            BigInteger n = new BigInteger(s);
            if(n.mod(BigInteger.TWO).equals(BigInteger.ZERO) || n.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO)){
                System.out.println("INVALID INPUT");
                continue;
            }
            BigInteger div = BigInteger.valueOf(11);
            int count = 2;
            while(!div.mod(n).equals(BigInteger.ZERO)){
                count++;
                div = div.multiply(BigInteger.valueOf(10)).add(BigInteger.ONE);
            }
            if(n.equals(BigInteger.ONE)){
                count=1;
            }
            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ones().run();
    }
}
