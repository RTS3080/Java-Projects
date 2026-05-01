import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Ramiro{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ramiro".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
//        f.useRadix(16);
        for(int times = 0; times < numTimes; times++){
            long a = Long.parseLong(f.next(), 16);
            long b= Long.parseLong(f.next(), 16);
            long x = a ^ b;
            String bit = Long.toBinaryString(x);
            int count = 0;
            for(char c : bit.toCharArray()){
                if(c=='1'){
                    count++;
                }
            }
            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ramiro().run();
    }
}
