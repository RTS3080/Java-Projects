import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class cd{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cd".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        while(f.hasNext()){
            double size = f.nextDouble();
            long cds = (long)Math.ceil(size/700);
            size-=(cds)*700;
            size = Math.abs(-size);

            System.out.printf("%s - %.1f\n", cds, size);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cd().run();
    }
}
