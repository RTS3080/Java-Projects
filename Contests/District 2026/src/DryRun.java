import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class DryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("DryRun".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            System.out.printf("I like %s.\n", f.next());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new DryRun().run();
    }
}
