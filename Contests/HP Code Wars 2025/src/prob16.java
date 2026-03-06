import java.util.*;
import java.io.*;

public class prob16{

    public void run() throws FileNotFoundException{
        HashMap<String, Double> conversions = new HashMap<>();
        String[] units = "y ft m in".split(" ");
        double[] dubs = {3./5280, 1./5280, (1/.3048)/5280., (1./12)/5280};
        for (int i = 0; i < dubs.length; i++) {
            conversions.put(units[i], dubs[i]);
        }
        Scanner f= new Scanner(System.in);
        double len = f.nextDouble();
        String unit = f.nextLine().trim();
        double time = f.nextDouble()/3600;
        len *= conversions.get(unit);
//        System.out.println(len);
        int a =(int) ((len/time) * 100);
//        System.out.println(a);
        double b = a/100.;
        System.out.printf("%.2f miles/hour", b);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob16().run();
    }
}
