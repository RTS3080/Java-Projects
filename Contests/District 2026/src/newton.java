import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class newton{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("newton".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int size = f.nextInt();
            for (int i = 1; i <= size; i++) {
                System.out.print(" ".repeat(size - i));
                System.out.println("*".repeat(i*2-1));
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new newton().run();
    }
}
