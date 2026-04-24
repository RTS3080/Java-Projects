import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryrun".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            System.out.println("I like "+f.next()+".");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
