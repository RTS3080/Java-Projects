import java.util.*;
import java.io.*;

public class party{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("party".toLowerCase()+".dat"));
        double tot = 0;
        while(f.hasNext()){
            double a = f.nextDouble();
            double b = f.nextDouble();
            tot+=a*b;
        }
        System.out.println((int)Math.ceil(tot));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new party().run();
    }
}
