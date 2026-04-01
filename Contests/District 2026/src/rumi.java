import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rumi{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rumi".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        double x = 3;
        double y= 4;
        double z = 0;
        double dist = 0;
        for(int times = 0; times < numTimes; times++){
            double newX = f.nextDouble();
            double newY = f.nextDouble();
            double newZ = f.nextDouble();
            dist +=sqrt(pow(newX-x, 2)+ pow(newY-y, 2)+ pow(newZ-z, 2));
            x = newX;
            y = newY;
            z = newZ;
        }
        dist += sqrt(pow(3-x, 2)+ pow(4-y, 2)+ pow(0-z, 2));
        System.out.printf("Total Distance: %.2f units\n", dist);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rumi().run();
    }
}
