import java.util.*;
import java.io.*;

public class Vivek{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Vivek".toLowerCase()+".dat"));
        int k = f.nextInt();
        f.nextLine();
        for (int t = 0; t < k; t++) {
            int cnt= 0;
            double x = f.nextDouble();
            double y = f.nextDouble();
            double z = f.nextDouble();
            double fuel = f.nextDouble();
            int loop = f.nextInt();
            f.nextLine();
            for (int i = 0; i < loop; i++) {
                f.next();
                if (f.next().equals("true")) {
                    double a = f.nextDouble();
                    double b = f.nextDouble();
                    double c  = f.nextDouble();
                    if (calc(x,y,z,a,b,c)<=fuel){
                        cnt++;
                    }
                }
                f.nextLine();
            }
            if (cnt>0){
                System.out.println("We made it Rick: " + cnt);
            }else{
                System.out.println("SS Madame de Pompadour");
            }
        }
        f.close();
    }

    public double calc (double x, double y, double z, double a, double b, double c){
        return Math.sqrt(Math.pow(x-a,2)+Math.pow(y-b,2)+Math.pow(z-c,2));
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Vivek().run();
    }
}
