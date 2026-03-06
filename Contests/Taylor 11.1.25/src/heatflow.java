import java.util.*;
import java.io.*;
import java.awt.*;

public class heatflow{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("heatflow".toLowerCase()+".in"));
        double l = f.nextDouble();
        double m = f.nextDouble();
        double D = f.nextDouble();
        double T = f.nextDouble();
        double g = f.nextDouble();
        double t = f.nextDouble();
        double r = Math.sqrt(m/(3.14*l*D));
        double A = 3.14*r*r;
        System.out.println(m/(D*l));
        double Hf = 334*g/1000;
        System.out.println(r);
        System.out.println(Hf+" "+l+" "+A+" "+T+" "+t);
        double out = (Hf*l)/(A*T*t);
        System.out.println(out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new heatflow().run();
    }
}
