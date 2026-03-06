import java.util.*;
import java.io.*;
import java.awt.*;

public class escapeVelocity{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("escapeVelocity".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double m  = f.nextDouble();
            double M = f.nextDouble()*1e12;
            double r = f.nextDouble()*1000;
            double G = 6.67e-11;
            double v = Math.sqrt(2 * M * G / r);
            System.out.printf("%.2f%n", v);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new escapeVelocity().run();
    }
}
