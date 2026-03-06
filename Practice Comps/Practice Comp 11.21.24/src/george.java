import java.util.*;
import java.io.*;

public class george{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("george".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double mpg = f.nextDouble();
            double gals = f.nextDouble();
            double dist = f.nextDouble();
            System.out.println(mpg * gals >=     dist? "Never tell me the odds." : "I've got a bad feeling about this.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new george().run();
    }
}
