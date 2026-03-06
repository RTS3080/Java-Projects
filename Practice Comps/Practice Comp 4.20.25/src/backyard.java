import java.util.*;
import java.io.*;
import java.awt.*;

public class    backyard{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("backyard".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        final double railLength = 72;
        final double picketWidth = 1.75;
        while(times-->0){
            double length = f.nextDouble() * 12;
            double horizLen = length * 2;
            double numRails = horizLen / railLength;
            if(numRails%1 !=0){
                numRails = (int)numRails+1;
            }
            double pickLen =0;
            double repeatDist =0;
            int pickCount= 0;
            while(pickLen < length-picketWidth){
                pickLen +=picketWidth+1./8;
                pickCount++;
                repeatDist += picketWidth + 1./8;
                if(repeatDist > 120){
                    repeatDist = 0;
                    pickCount++;
                }
            }
            pickCount++;
            double diff = pickLen-(pickCount- length/120) * (picketWidth+1./8);
            while(diff >= picketWidth+1.0/8){
                pickCount++;
                diff = pickLen-(pickCount- length/120) * (picketWidth+1./8);
            }
//            System.out.println(diff);
            System.out.printf("%.0f %d\n", numRails, pickCount);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new backyard().run();
    }
}
