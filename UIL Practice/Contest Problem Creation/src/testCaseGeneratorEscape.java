import java.util.*;
import java.io.*;
import java.awt.*;

public class testCaseGeneratorEscape{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            Random r=new Random();
            System.out.print(r.nextInt(1, 1000000)+" ");
            System.out.print((r.nextLong(1, 10_000_000)*100000000)+" ");
            System.out.printf("%.2f\n", r.nextDouble(0.0000000001, 1000000));
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new testCaseGeneratorEscape().run();
    }
}
