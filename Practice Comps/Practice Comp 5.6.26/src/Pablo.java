import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Pablo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Pablo".toLowerCase()+".dat"));
        final double R = 6371000.;
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            double lat1 = toRadians(f.nextDouble());
            double lon1 = toRadians(f.nextDouble());
            double lat2 = toRadians(f.nextDouble());
            double lon2 = toRadians(f.nextDouble());
            double latDiff = -(lat1-lat2);
            double lonDiff = -(lon1-lon2);
            double a = pow(sin(latDiff/2),2) + cos(lat1)*cos(lat2)*pow(sin(lonDiff/2),2);
            double c = 2 * atan2(sqrt(a), sqrt(1-a));
            double d = R * c;
            System.out.printf("The distance between (%.5f, %.5f) and (%.5f, %.5f) is %.0f meters.\n", toDegrees(lat1), toDegrees(lon1), toDegrees(lat2), toDegrees(lon2), d);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Pablo().run();
    }
}
