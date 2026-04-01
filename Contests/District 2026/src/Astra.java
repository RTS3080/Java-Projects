import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Astra{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Astra".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        while(f.hasNext()){
            String name = f.next();
            System.out.println("GROUP ORDER: "+name);
            System.out.println("-".repeat(42));

            int size = f.nextInt();
            double modifier = size >=5 ? .9:1;
            double totCost = 0;
            for (int i = 1; i <= size; i++) {
                int grade = f.nextInt();
                String type = f.next();
                double cost = 0;
                if (type.equals("REGULAR")) {
                    cost = 40;
                } else {
                    cost = 55;
                }
                cost += (12 - grade) * 5;
                if (grade == 9) cost -=5;
                cost *= modifier;
                totCost += cost;
                System.out.printf("Student #%-2d%-22s: $%7.2f\n", i, String.format("(Grade %d, %s)", grade, type), cost);
            }
            System.out.println("-".repeat(42));
            String s = "Group Total";
            if(size >=5 ){
                s+=" (Disc. Applied)";
            }
            System.out.printf("%-33s: $%7.2f\n", s, totCost);
            System.out.println("\n");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Astra().run();
    }
}
