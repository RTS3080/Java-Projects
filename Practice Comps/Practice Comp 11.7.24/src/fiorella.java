import java.util.*;
import java.io.*;

public class fiorella{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fiorella".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double w = f.nextDouble();
            double x = f.nextDouble();
            double y = f.nextDouble();
            double z = f.nextDouble();
            double G = f.nextDouble();
            double n = Math.log((G-z)/(w*y))/Math.log(x);
            System.out.println((int)n);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fiorella().run();
    }
}
