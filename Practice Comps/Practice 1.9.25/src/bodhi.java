import java.util.*;
import java.io.*;

public class bodhi{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bodhi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            double pv = f.nextDouble();
            double apr = f.nextDouble()/100;
            double pers = f.nextDouble();
            double n = f.nextDouble();
            double fv = pv * Math.pow((1 + (apr/pers)),n);
            double profit = fv-pv;
            System.out.printf("$%.2f $%.2f\n",fv,profit);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bodhi().run();
    }
}
