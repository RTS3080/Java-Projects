import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class accounting{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("accounting".toLowerCase()+".dat"));
        double balance = 0;
        System.out.println("****.".repeat(8));
        System.out.println(" ".repeat(7)+"Transcation : Balance");
        while(f.hasNext()){
            String s = f.next();
            double sign = 1;
            if(s.contains("("))
                sign = -1;
            s = s.replaceAll("[$(),]", "");
            double d= Double.parseDouble(s) * sign;

            balance += d;
            String transaction = "$"+String.format("%(,.2f", d);
            transaction = " ".repeat(18-transaction.length()) + transaction;
            String bal = "$"+String.format("%(,.2f", balance);
            System.out.println(transaction + " : "+bal);
        }
        System.out.println("****.".repeat(8));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new accounting().run();
    }
}
