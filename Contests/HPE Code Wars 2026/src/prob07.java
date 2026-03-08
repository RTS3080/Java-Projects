import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob07{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob07".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String a= f.next();
            String b= f.next();
            String[] ar = a.split("\\.");
            String[] br = b.split("\\.");
            if(a.equals(b) ){
                System.out.println(a+" is identical");
                continue;
            }
            boolean aNewer = true;
            for (int i = 0; i < 3; i++) {
                int aN = Integer.parseInt(ar[i]);
                int bN = Integer.parseInt(br[i]);
                if(aN > bN){
                    aNewer = true;
                    break;
                }
                else if(aN < bN){
                    aNewer = false;
                    break;
                }
            }
            String out = aNewer ? a : b;
            System.out.println(b+" is "+(aNewer ? "older" : "newer"));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob07().run();
    }
}
