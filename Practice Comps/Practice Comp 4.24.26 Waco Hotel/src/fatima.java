import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class fatima{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fatima".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++) {
            double tempStep = f.nextDouble();
            double humidStep = f.nextDouble();
            ArrayList<Double> temps = new ArrayList<>();
            ArrayList<Double> humidities = new ArrayList<>();
            double temp = 80;
            double humidity = 20;
            while (temp <= 125) {
                temps.add(temp);
                temp += tempStep;
            }
            while (humidity <= 100) {
                humidities.add(humidity);
                humidity += humidStep;
            }
            String t = "Temp  ";
            for (double d : temps) {
                t += String.format("%5.1f ", d);
            }
            t = t.trim();
            System.out.println(t);
            System.out.println("Humid " + "=".repeat(95));
            for (Double h : humidities) {
                String out = String.format("%5.1f ", h);
                for (Double tem : temps) {
                    double HI = getHeatIndex(h, tem);
                    if (HI != -1) {
                        out += String.format("%5.1f ", HI);
                    }
                }
                System.out.println(out.substring(0,out.length()-1));
            }
            System.out.println("=".repeat(30));
        }
        f.close();
    }
    double getHeatIndex(double h, double t){
        double HI = -42.379  + 2.04901523 * t + 10.14333127 * h - 0.22475541 * t * h - 6.83783E-3 * t * t
                -5.481717E-2 * h * h + 1.22874E-3 * t * t * h + 8.5282E-4 * t * h * h - 1.99E-6 * t * t * h * h;
        if( h > 85){
            HI += ((h-85)/10 * (87 - t)/5);
        }
        if(HI > 140) return -1;
        return HI;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new fatima().run();
    }
}
