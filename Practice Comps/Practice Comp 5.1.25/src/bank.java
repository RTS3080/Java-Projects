import java.util.*;
import java.io.*;
import java.awt.*;

public class bank{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bank".toLowerCase()+".dat"));
        int[] ln = Arrays.stream(f.next().split("-")).mapToInt(Integer::parseInt).toArray();
        int prevMonth = ln[0]*12 + ln[1];
        double amt = f.nextDouble();f.nextLine();
        while(f.hasNext()){
            ln = Arrays.stream(f.next().split("-")).mapToInt(Integer::parseInt).toArray();
            int newmonth = ln[0]*12 + ln[1];
            if(newmonth != prevMonth){
                amt = amt * Math.pow(1.02, newmonth-prevMonth);
            }
            amt +=f.nextDouble();
            prevMonth = newmonth;
            f.nextLine();
        }
        int a = (int)(amt * 100);
        System.out.println("$"+(double) a/100);
        f.close();

    }



    public static void main(String[] args) throws FileNotFoundException{
        new bank().run();
    }
}
