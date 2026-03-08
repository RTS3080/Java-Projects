import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob13{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob13".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String s = f.next();
        String[] orig = s.split(":");
        int mins = Integer.parseInt(orig[0])*60 + Integer.parseInt(orig[1]);
        while(f.hasNext()){
            String str = f.next();
            if(str.equals("0.0x")) break;
            str = str.substring(0, str.length()-1);
            double mult = Double.parseDouble(str);
            int mewMins = (int)(mins/mult);
            int newHrs = mewMins/60;
            mewMins -= newHrs*60;
            System.out.printf("%s is %d:%02d at %sx speed\n", s, newHrs, mewMins, str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob13().run();
    }
}
