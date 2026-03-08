import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob02{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob02".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        System.out.println("Meme fixed? "+f.nextLine()+", Bet!");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob02().run();
    }
}
