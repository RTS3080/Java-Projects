import java.util.*;
import java.io.*;

public class dawn{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dawn".toLowerCase()+".dat"));
        System.out.println("     Amount                              Monthly         Total of");
        System.out.println("....Invested........APR......Years......Payment.........Payments.\tProfit..");
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            double initial = f.nextDouble();
            double apr = f.nextDouble()/100;
            apr/=12;
            int years = f.nextInt();
            double payment;
            payment =initial+apr;
            payment/= (1-Math.pow(1+apr,-years));
            System.out.printf("$% ,10.2f  |  % 3.3f%%  |\n",payment,apr*1200);
        }
        f.close();
;
    }

    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new dawn().run();
    }
}
