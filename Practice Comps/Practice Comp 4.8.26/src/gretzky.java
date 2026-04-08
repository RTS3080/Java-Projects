import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class gretzky{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gretzky".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String s= f.next();
            String streak = f.next();
            int maxStreak = 0;
            int p1 = 0;
            int currCnt = 0;
            while(p1 < streak.length()){
                if(streak.charAt(p1) == 'W'){
                    currCnt++;
                }
                else currCnt=0;
                maxStreak = Math.max(maxStreak, currCnt);
                p1++;
            }
            maxStreak = Math.max(maxStreak, currCnt);
            System.out.println(s+": "+maxStreak);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new gretzky().run();
    }
}
