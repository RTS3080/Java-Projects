import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class twister{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("twister".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int original = f.nextInt();
            int change = f.nextInt();
            change%=360;
            original-=change;
            if(original < 0){
                original+=360;
            }
            System.out.printf("The new heading is %3d\n", original);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new twister().run();
    }
}
