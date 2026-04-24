import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class numberCrunching{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("numberCrunching".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        long a = f.nextLong();
        long b = f.nextLong();
        if(a < b){
            long temp = a;
            a = b;
            b = temp;
        }




        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new numberCrunching().run();
    }
}
