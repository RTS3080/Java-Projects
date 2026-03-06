import java.util.*;
import java.io.*;

public class pablo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pablo".toLowerCase()+".dat"));

        int cases = f.nextInt();

        while(cases-- > 0){
            double pLA1 = f.nextDouble();
            double pLO1 = f.nextDouble();

            double LA1 = Math.toRadians(pLA1);
            double LO1 = Math.toRadians(pLO1);

            double pLA2 = f.nextDouble();
            double pLO2 = f.nextDouble();

            double LA2 = Math.toRadians(pLA2);
            double LO2 = Math.toRadians(pLO2);

            double dLA = Math.abs(LA1-LA2);
            double dLO = Math.abs(LO1-LO2);

            double a = Math.pow((Math.sin(dLA/2.0)),2)+(Math.cos(LA1)*Math.cos(LA2)*Math.pow((Math.sin(dLO/2.0)),2));
            double c = 2.0*(Math.atan2(Math.sqrt(a),Math.sqrt(1.0-a)));
            double dis = 6371.0*c*1000;
            System.out.printf("The distance between (%.5f, %.5f) and (%.5f, %.5f) is %.0f meters.%n", pLA1, pLO1, pLA2, pLO2, dis);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pablo().run();
    }
}
