import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class time{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("time".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        while(f.hasNext()){
            f.next();
            int time = f.nextInt()%(24*3600);
            f.next();

            boolean am = true;
            if(time >= 12*3600){
                am = false;
            }
            time%=12*3600;
            int hours = time / 3600;
//            System.out.println(time);
            time%=3600;
            int minutes = time/(60);
//            System.out.println(time);
            time%=60;
            int seconds = time % 60;
//            System.out.println(time);
            if (hours == 0){
                hours = 12;
            }
            System.out.printf("%02d:%02d:%02d %s\n",hours,minutes,seconds, am?"am":"pm");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new time().run();
    }
}
