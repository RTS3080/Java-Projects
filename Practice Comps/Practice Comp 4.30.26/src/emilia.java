import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class emilia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("emilia".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double hour = -f.nextDouble();
            double minute = -f.nextDouble();
            hour+=90;
            minute+=90;
            while(hour < 0) hour +=360;
            while(minute < 0) minute +=360;
            hour=(hour/30)%12;
            minute=minute / 6;
            if(hour < 1) hour = 12;
            int hourInt = (int) hour;
            int minuteInt = (int) minute;
            System.out.printf("%02d:%02d\n",hourInt,minuteInt);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new emilia().run();
    }
}
