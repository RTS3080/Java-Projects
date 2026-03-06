import java.util.*;
import java.io.*;

public class lamps{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int hours = f.nextInt();
        int elecPrice = f.nextInt();
        double Kinc = 60 * hours * elecPrice/100_000.0;
        double Klow = 11 * hours * elecPrice/100_000.0;
        int pinc = 5;
        int plow = 60;
        double incPrice = pinc;
        double lowPrice = plow;
        int days=0;
        int boughtInc=1;
        while(incPrice<lowPrice){
            int hoursOn = days*hours;
            if(hoursOn>1000*boughtInc){
                boughtInc++;
            }
            incPrice =pinc*boughtInc+Kinc*days;
            lowPrice =plow+Klow*days;
            days++;
        }
//        System.out.println(incPrice+" "+lowPrice+" "+days);
        System.out.println(days-1);
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new lamps().run();
    }
}
