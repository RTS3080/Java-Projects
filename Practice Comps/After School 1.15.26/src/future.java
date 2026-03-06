import java.util.*;
import java.io.*;
import java.awt.*;

public class future{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("future".toLowerCase()+".dat"));
        int times=in.nextInt(); in.nextLine();
        while(times-->0){
            double l = in.nextDouble();
            double f = in.nextDouble();
            double n = in.nextDouble();
            double s = in.nextDouble();
            double w = in.nextDouble();
            double numerator = Math.pow(f, n) * ((s * l) / f + Math.pow(20/f, w));
            double val = l - (numerator / Math.pow(20, n));
            System.out.printf("%.2f\n", val);

        }
        in.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new future().run();
    }
}
