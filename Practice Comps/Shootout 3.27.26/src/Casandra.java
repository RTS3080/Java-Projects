import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Casandra{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Casandra".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String ln = f.nextLine();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Casandra().run();
    }
}
