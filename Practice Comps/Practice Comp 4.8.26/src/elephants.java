import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class elephants{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("elephants".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            char side = f.next().charAt(0);
            double sideVal=f.nextDouble();
            double angle=f.nextDouble();
            if(side == 'H'){
                System.out.printf("%.3f\n", hypot(sideVal, angle));
            }
            else if(side == 'O'){
                System.out.printf("%.3f\n", sin(toRadians(angle))*sideVal);
            }
            else if(side == 'A'){
                             System.out.printf("%.3f\n", cos(toRadians(angle))*sideVal);
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new elephants().run();
    }
}
