import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class delayedGraphics{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("delayedGraphics".toLowerCase()+".in"));
        int numTimes=f.nextInt();
        for(int times = 0; times < numTimes; times++){
            long maxTime = f.nextLong();
            long delay = f.nextLong() + f.nextLong();
            if(delay <= maxTime){
                System.out.println("PASS");
            }
            else{
                System.out.println(delay-maxTime);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new delayedGraphics().run();
    }
}
