import java.util.*;
import java.io.*;
import java.awt.*;

public class world{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("world".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double m = f.nextDouble();
            double e = f.nextDouble();
            double f1 = f.nextDouble();
            double t = f.nextDouble();
            double c = f.nextDouble();
            double val = Math.min(m/.05, Math.min(e/12000, f1+t+c));
            System.out.println((int) val);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new world().run();
    }
}
