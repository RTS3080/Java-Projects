import java.util.*;
import java.io.*;

public class Bhodi{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bodhi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double pv = f.nextDouble();
            double rate = f.nextDouble()/100;
            int periods = f.nextInt();
            int t = f.nextInt();
//            System.out.println(rate/periods);
            double fv = pv*Math.pow(1+(rate/periods),t);
            double profit = fv-pv;
            System.out.printf("$%.2f $%.2f\n",fv,profit);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bhodi().run();
    }
}
