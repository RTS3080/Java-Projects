import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob01{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob01".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        System.out.println("Welcome to HPE CodeWars, Crunchy Cat! Don't worry! It's going to be fun!");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob01().run();
    }
}
