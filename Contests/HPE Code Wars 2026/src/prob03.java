import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob03{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob03".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String ln = f.nextLine();
        System.out.println(ln+ln+ln);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob03().run();
    }
}
