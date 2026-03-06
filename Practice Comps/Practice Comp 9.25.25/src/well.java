import java.util.*;
import java.io.*;
import java.awt.*;

public class well{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("well".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String name = f.next();
            double M = f.nextDouble();
            double R = f.nextDouble();
            double Mr = f.nextDouble();
            double Veng = f.nextDouble();
            double G = 6.674e-11;
            double Vesc = Math.sqrt(2*G*M/R);
            double Mratio = Math.pow(2.71828, Vesc/Veng);
            double Mf = Mratio/Mr - Mr;
            System.out.printf("%s: %,.3f, %,.3f\n", name, Vesc, Mf);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new well().run();
    }
}
