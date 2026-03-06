import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class falling{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("falling".toLowerCase()+".in"));
        double h = f.nextDouble();
        double maxVelo = f.nextDouble();
        double velo = sqrt(2 * 9.8 * h);
        System.out.println(velo <= maxVelo ? "THEY LIVES" : "oops");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new falling().run();
    }
}
