import java.util.*;
import java.io.*;
import java.awt.*;

public class power{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("power".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double b = f.nextDouble();
            double a = f.nextDouble();
            double efficiency = 100*a/b;
//            System.out.println(efficiency);
            if(efficiency<95) System.out.println("But I was gonna go to Tosche station to pick up some power converters.");
            else if (efficiency>=95 && efficiency<=100){
                System.out.println("They fly now!");
            }
            else if (efficiency>100){
                System.out.println("The dark side of the Force is a pathway to many abilities some consider... unnatural.");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new power().run();
    }
}
