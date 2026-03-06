import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class planetaryWeight{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("planetaryWeight".toLowerCase()+".in"));
        String[] planets = "Mercury Venus Earth Mars Jupiter Saturn Uranus Neptune".split(" ");
        String ratioStr = ".377 .905 1 .379 2.528 1.065 .886 1.137";
        double[] ratios = Arrays.stream(ratioStr.split(" ")).mapToDouble(Double::parseDouble).toArray();
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double start = f.nextDouble();
            for (int i = 0; i < planets.length; i++) {
                System.out.printf("%s: %.1f\n", planets[i], ratios[i]*start);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new planetaryWeight().run();
    }
}
