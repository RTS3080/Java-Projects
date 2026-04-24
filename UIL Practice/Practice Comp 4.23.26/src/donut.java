import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class donut{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("donut".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Strawberry_Donut", 1.75);
        prices.put("Chocolate_Donut", 1.6);
        prices.put("Vanilla_Donut", 1.6);
        prices.put("Blueberry_Donut", 1.8);
        prices.put("Glazed_Donut", 1.45);
        prices.put("TX_Sized_Donut", 8.5);
        prices.put("Cinnamon_Twist", 2.25);
        prices.put("Coffee", 2.15);
        prices.put("Sausage_Kolache", 1.1);
        prices.put("Cheese_Kolache", 1.5);
        prices.put("Donut_Holes", 3.);
        prices.put("Chocolate_Milk", 3.05);
        for(int times = 0; times < numTimes; times++){
            String[] ln = f.nextLine().split(" ");
            double price = 0;
            for(String s : ln){
                price+=prices.get(s);
            }
            price *= 1.0825;
            System.out.printf("$%.2f\n", price);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new donut().run();
    }
}
