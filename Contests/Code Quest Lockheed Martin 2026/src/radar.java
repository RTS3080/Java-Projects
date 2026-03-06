import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class radar{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("radar".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double theta1 = toRadians(f.nextDouble());
            double r1 = f.nextDouble();
            double theta2 = toRadians(f.nextDouble());
            double r2 = f.nextDouble();
            double[] coord1 = {cos(theta1)*r1, sin(theta1)*r1};
            double[] coord2 = {cos(theta2)*r2, sin(theta2)*r2};
            double dist = hypot(coord1[0]-coord2[0], coord1[1]-coord2[1]);
            double heading = atan2((coord2[1]-coord1[1]),(coord2[0]-coord1[0]));
            if(heading < 0) heading +=2 * PI;
            System.out.printf("%.0f %.0f\n", dist*10, toDegrees(heading));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new radar().run();
    }
}
