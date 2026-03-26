import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bases{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bases".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int n = f.nextInt();
        System.out.println("Base 10   Base 2    Base 4    Base 8    Base 12   Base 16");
        for (int i = 1; i <=n; i++) {
            String two = Integer.toString(i, 2);
            String four = Integer.toString(i, 4);
            String twelve = Integer.toString(i, 12);
            System.out.printf("%-10d%-10s%-10s%-10o%-10s%-10h\n", i,two, four, i, twelve, i);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bases().run();
    }
}
