import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Bongo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bongo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bongo().run();
    }
}
