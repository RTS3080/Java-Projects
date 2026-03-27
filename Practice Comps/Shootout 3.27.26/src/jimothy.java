import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jimothy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jimothy".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jimothy().run();
    }
}
