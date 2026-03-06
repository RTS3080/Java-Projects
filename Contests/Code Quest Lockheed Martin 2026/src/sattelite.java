import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class sattelite{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("sattelite".toLowerCase()+".in"));
        final double G = 6.673E-11;
        final double M = 5.98E24;
        final double Rearth = 6.37E6;
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double h = f.nextDouble();
            double R = Rearth + h;
            double v = sqrt(G * M / R);
            double t= sqrt(4 * PI * PI * pow(R,3) / (G * M));
            int hours = (int)t /3600;
            t-=hours*3600;
            int mins = (int)t /60;
            t-=mins*60;
            int secs = (int) round(t);
            System.out.printf("%.0f %d:%02d:%02d\n",v,hours,mins,secs);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sattelite().run();
    }
}
