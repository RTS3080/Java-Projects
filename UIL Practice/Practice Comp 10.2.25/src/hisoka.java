import java.util.*;
import java.io.*;
import java.awt.*;

public class hisoka{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hisoka".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double p = f.nextDouble();
            double r = f.nextDouble()/1200;
            double n = f.nextDouble();
            double v = p * ((Math.pow(1+r, n*12)-1)/r);
            double sum = p * 12 * n;
            double interest = v-sum;
            System.out.printf("%.2f %.2f %.2f\n", sum, interest, v);
//            System.out.println(v);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hisoka().run();
    }
}
