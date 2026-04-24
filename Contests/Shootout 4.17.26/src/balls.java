import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class balls{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("balls".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new balls().run();
    }
}
