import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ultimate{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ultimate".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        char[] correct = new char[11];
        String corr = "LLARLRDABRU";
        for (int i = 0; i < 11; i++) {
            correct[i] = corr.charAt(i);
        }
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            double numRight = 0;
            int total = 0;
            for (int i = 0; i < ln.length; i++) {
                if(i >= correct.length){
                    continue;
                }
                if(ln[i].charAt(0) == correct[i]){
                    numRight++;
                }
            }
            System.out.printf("%.2f%%\n", 100*numRight/Math.max(ln.length, 11));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ultimate().run();
    }
}
