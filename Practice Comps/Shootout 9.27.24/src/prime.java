import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class prime{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prime".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int num = f.nextInt();
            for(int i = num; i>0; i--){
                BigInteger a = new BigInteger(""+i);
                if(num%i==0 && a.isProbablePrime(100)){
                    System.out.println(a);
                    break;
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prime().run();
    }
}
