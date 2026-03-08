import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob06{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob06".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String ln = f.nextLine();
        String out = "";
        for(int i = 0; i < ln.length(); i+=2){
            out+=ln.charAt(i);
        }
        for (int i = 1; i < ln.length(); i+=2) {
            out+=ln.charAt(i);
        }
        System.out.println(out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob06().run();
    }
}
