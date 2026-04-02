import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bruce{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bruce".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double d=  4*sqrt(f.nextDouble());
            System.out.printf("%.4f\n", d);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bruce().run();
    }
}
