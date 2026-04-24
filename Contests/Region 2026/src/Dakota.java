import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Dakota{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Dakota".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();
        String lineBreak = "+"+"-".repeat(42)+"+";
        for(int times = 0; times < numTimes; times++){
            String name = f.next();
            System.out.println(lineBreak);
            System.out.printf("| Invoice for %-29s|\n", name);
            System.out.println(lineBreak);
            System.out.println("| Item         Qty     Price     Subtotal  |");
            System.out.println(lineBreak);
            double subtotal = 0;
            int times2=f.nextInt();
            while(times2-->0){
                String item = f.next();
                int quantity = f.nextInt();
                double price = f.nextDouble();
                subtotal += quantity*price;
                String priceformat = String.format("%.2f", price);
                String totalformat = String.format("%.2f", price * quantity);
                String out = totalformat+"   |";
                out=" ".repeat(12-totalformat.length())+out;
                out = priceformat+out;
                out = " ".repeat(11- priceformat.length())+out;
                out = quantity+out;
                out = item +" ".repeat(15-item.length()-(""+quantity).length())+out;
                out = "| "+out;
                System.out.println(out);
//                System.out.printf("| %-14s%-7d%-11.2f%-8.2f |\n", item, quantity, price, price * quantity);
            }
            double tax = subtotal *.0825;
            double total = subtotal + tax;
            System.out.println(lineBreak);
            System.out.printf("| Subtotal:%31.2f |\n", subtotal);
            System.out.printf("| Tax:%36.2f |\n", tax);
            System.out.printf("| Total:%34.2f |\n", total);
            System.out.println(lineBreak);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Dakota().run();
    }
}
