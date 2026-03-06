import java.util.*;
import java.io.*;
import java.awt.*;

public class Venue{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Venue".toLowerCase()+".dat"));
        int times=f.nextInt(); int hours = f.nextInt();f.nextLine();
        while(times-->0){
            String name = f.next();
            double cost = f.nextDouble();
            double x = f.nextDouble();
            double y = f.nextDouble();
            double area = x*y;
            double costPer = cost/area/hours;
            System.out.printf("%s %.6f\n", name, costPer);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Venue().run();
    }
}
