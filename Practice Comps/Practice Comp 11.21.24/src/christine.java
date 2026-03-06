import java.util.*;
import java.io.*;

public class christine{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("christine".toLowerCase()+".dat"));
        int times=5;
        int a = f.nextInt();
        while(times-->0){
            int next = f.nextInt();
            int sign = (int)Math.signum(next-a);
            while(a!=next){
                System.out.print(a+" ");
                a+=sign;
            }
            System.out.println();

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new christine().run();
    }
}
