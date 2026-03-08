import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob04{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob04".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        System.out.println(f.nextInt()*2);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob04().run();
    }
}
