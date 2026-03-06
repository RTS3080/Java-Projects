import java.util.*;
import java.io.*;

public class receipt{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("receipt".toLowerCase()+".dat"));
        int times=in.nextInt(); in.nextLine();
        for(int abc = 1; abc <=times; abc++){
            System.out.println("Grocery Store #"+abc+":");
            String one = in.next();
            String two = in.next();
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double d = in.nextDouble();
            double e = in.nextDouble();
            double f = in.nextDouble();
            double denom =e - (d * b)/a;

            double y= (f-(d * c)/a)/denom;
            double x = (c - b*y)/a;
            if(denom==0 || y<0 || x<0){
                System.out.println("CANNOT COMPUTE PRICES");
                continue;
            }
            System.out.printf("%s: %1.2f, %s: %1.2f\n", one, x, two, y);
        }
        in.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new receipt().run();
    }
}
