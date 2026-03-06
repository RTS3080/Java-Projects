import java.sql.Time;
import java.util.*;
import java.io.*;
import java.awt.*;

public class time{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("time".toLowerCase()+".dat"));
        while(f.hasNext()){
            f.nextLine();
            Time t = new Time(6*60*60*1000);
            int secs = f.nextInt(); f.nextLine();
            t.setTime(secs*1000 + t.getTime());
            String[] s = t.toString().split(":");
            int hours = Integer.parseInt(s[0]);
            int minutes = Integer.parseInt(s[1]);
            int seconds = Integer.parseInt(s[2]);
            String dt = "am";
            if(hours >= 12){
                int nums = hours / 12;
                hours %= 12;
                if(nums%2==1){
                    dt = "pm";
                }
            }
            if(hours == 0){
                hours = 12;
            }
            System.out.printf("%02d:%02d:%02d %s\n", hours, minutes, seconds, dt);
            f.nextLine();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new time().run();
    }
}
