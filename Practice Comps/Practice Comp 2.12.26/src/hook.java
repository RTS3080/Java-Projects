import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class hook{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hook".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double x = f.nextDouble();
            double y = f.nextDouble();
            double t = y/100;
            y +=t*50;
            double theta = toDegrees(atan2(y, x));
            System.out.printf("%.3f\n", theta);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hook().run();
    }
}
