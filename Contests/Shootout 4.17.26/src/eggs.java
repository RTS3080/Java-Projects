import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class eggs{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("eggs".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int num = f.nextInt();
            System.out.println((1 << num)-1);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new eggs().run();
    }
}
