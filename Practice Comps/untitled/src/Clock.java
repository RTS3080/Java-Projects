import java.util.*;
import java.io.*;

public class Clock{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Clock".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().split(":");
            int hours = Integer.parseInt(ln[0]);
            int minutes = Integer.parseInt(ln[1]);
            hours = Math.abs(12-hours);
            minutes = Math.abs(59-minutes);
            minutes++;
            if(hours == 0)
                hours = 12;
            if(minutes == 60){
                minutes = 0;
                hours++;
            }
            hours--;
            if(hours == 0){
                hours=12;
            }
            System.out.printf("%d:%02d\n", hours, minutes);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Clock().run();
    }
}
