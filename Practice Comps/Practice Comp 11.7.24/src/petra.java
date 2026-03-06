import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class petra{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("petra".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n=f.nextInt();
            int reverse = Integer.parseInt(new StringBuilder(n+"").reverse().toString());
            int i = Math.min(n,reverse);

            while(i>0){
                if(n%i == 0 && reverse%i==0){
                    break;
                }
                i--;
            }
            System.out.println(i);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new petra().run();
    }
}
