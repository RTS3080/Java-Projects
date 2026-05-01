import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Deepa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Deepa".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numBrackets=f.nextInt();
            double amt = f.nextDouble();
            int[] brackets = new int[numBrackets];
            double[] percents = new double[numBrackets];
            for (int i = 0; i < numBrackets; i++) {
                int a= f.nextInt();
                double b = f.nextDouble()/100;
                brackets[i]=a;
                percents[i]=b;
            }
            double[] sub = new double[numBrackets];
            for (int i = 0; i < numBrackets-1; i++) {
                sub[i] = brackets[i+1]-brackets[i];
            }
            sub[sub.length-1] = amt - brackets[brackets.length-1];
            int i = 0;
            double amtUsed = 0;
            double amtPaid = 0;
            while(amtUsed < amt){
                if(amt-amtUsed >= sub[i]) {
                    amtPaid += sub[i] * percents[i];
                    amtUsed += sub[i];
                }
                else{
                    amtPaid+= (amt-amtUsed)*percents[i];
                    amtUsed =amt;
                }
                i++;
//                System.out.println(amtPaid+" "+amtUsed);
            }
//            System.out.println(amtPaid);
//            System.out.println("----------");
            double effectivePercent = amtPaid / amt * 100;
            System.out.printf("Case #%d: $%,.2f %.3f%%\n", times+1,amtPaid, effectivePercent);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Deepa().run();
    }
}
