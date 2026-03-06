import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sineup{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sineup".toLowerCase()+".dat"));
        while(f.hasNext()){
            double d = f.nextDouble();
            double alpha = f.nextDouble();
            double beta = f.nextDouble();
            double gamma = 180 - alpha - beta;
            double a = 0, b = 0, c = 0;
            a = d * sin(toRadians(alpha));
            b = d * sin(toRadians(beta));
            c = d * sin(toRadians(gamma));

            System.out.printf("Circumcircle diameter = %.0f\n", d);
            System.out.printf("Angles are %.0f, %.0f and %.0f\n", alpha, beta, gamma);
            System.out.printf("Corresponding sides are %.0f, %.0f and %.0f\n", a, b, c);


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sineup().run();
    }
}
