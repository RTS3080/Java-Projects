import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class explorer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("explorer".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        final double PI = 3.14159;
        while(f.hasNext()){
            f.next();
            double radius = f.nextDouble();
            double gas = f.nextDouble();
            double theta  = f.nextDouble() % 360;
            if(theta > 180) theta = 360-theta;
            f.next();
            theta = PI * theta / 180;
            double dist = 2 * radius * theta;
            double possibleDist = gas*5;
            if(dist <= possibleDist){
                System.out.printf("YES %d\n", (int)(gas-dist/5));
            }
            else{
                System.out.printf("NO %d\n", (int)(gas*5));
            }
//            System.out.println(dist);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new explorer().run();
    }
}
