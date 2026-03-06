import java.util.*;
import java.io.*;

public class Feng{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Feng".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double[] clock = Arrays.stream(f.nextLine().split(":")).mapToDouble(Double::parseDouble).toArray();
            double hour = clock[0];
            double minute = clock[1];
            double time = hour * 60 + minute;

            time *=360.0/720;
            minute*=360/60;
            time = (360-time+90)%360;
            minute = (360-minute+90)%360;
//            System.out.println(time);
//            System.out.println(minute);
            System.out.printf("Hour: %.1f Minute: %.1f\n",time,minute);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Feng().run();
    }
}
