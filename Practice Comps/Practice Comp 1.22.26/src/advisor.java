import javax.swing.plaf.synth.SynthFormattedTextFieldUI;
import java.util.*;
import java.io.*;
import java.awt.*;

public class advisor{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("advisor".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double a = f.nextDouble();
            double paycheck = f.nextDouble();
            double rate = f.nextDouble()/1200;
            double months = f.nextDouble();
            double amt = a;
            for (int i = 0; i < months; i++) {
                amt = paycheck + (amt) * (1 + rate);
            }
//            amt+=paycheck;
            double profit = amt - a;
            System.out.printf("%,.2f %,.2f\n", amt, profit);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new advisor().run();
    }
}
