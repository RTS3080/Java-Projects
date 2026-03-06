import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rey{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rey".toLowerCase()+".dat"));
        while(f.hasNext()){
            String name = f.next();
            int times=f.nextInt();
            System.out.println("INVOICE FOR: "+name);
            System.out.println("-".repeat(27));
            double totalCost = 0;
            while(times-->0){
                double cost = 0;
                String type = f.next();
                String size = f.next();
                if(type.equals("Hoodie")){
                    cost+=30;
                }
                else if(type.equals("TShirt")){
                    cost+=15;
                }
                if(size.equals("XL") || size.equals("XXL")){
                    cost+=2.5;
                }
                totalCost+=cost;
                System.out.printf("%s (%-8s $%7.2f\n",type,size+")",cost);
            }
            System.out.println("-".repeat(27));
            System.out.printf("Total Due:       $%7.2f\n",totalCost);
            System.out.println();

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rey().run();
    }
}
