import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class mcGregor{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mcGregor".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String s= f.next();
            int n = f.nextInt();
            System.out.print(s+" "+n+" - ");
            System.out.println((n <=99 && n>=1)?"Valid":"Invalid");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mcGregor().run();
    }
}
