import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Jason{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Jason".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double a = f.nextDouble();
            double b = f.nextDouble();
            double c = f.nextDouble();
            boolean up = a>0;
            double vertexX = -b/(2 * a);
            double vertexY = a * vertexX * vertexX + b*vertexX+c;
            System.out.printf("(%.3f,%.3f)-->%s\n",vertexX,vertexY, up?"UPWARD":"DOWNWARD");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Jason().run();
    }
}
