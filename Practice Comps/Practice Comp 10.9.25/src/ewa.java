import java.util.*;
import java.io.*;
import java.awt.*;

public class ewa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ewa".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double totalVol=0;
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String action = f.next();
                if(action.equals("BRING")){
                    double r= f.nextDouble();
                    double h = f.nextDouble();
                    totalVol+=r*r*h*Math.PI;
                }
                else if (action.equals("EAT")){
                    double a= f.nextDouble();
                    totalVol-=a;
                }
                System.out.printf("%.2f\n", totalVol);
            }
            System.out.println("-".repeat(10));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ewa().run();
    }
}
