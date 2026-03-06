import java.util.*;
import java.io.*;
import java.awt.*;

public class curve{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("curve".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int times2=f.nextInt();
            long k = f.nextLong();
            long maxCurve = 0;
            f.nextLine();
            while(times2-->0){
                long a = f.nextLong();
                long b = f.nextLong();
                long winner = Math.max(a, b);
                maxCurve = Math.max(k - winner, maxCurve);
            }
            System.out.println(maxCurve);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new curve().run();
    }
}
