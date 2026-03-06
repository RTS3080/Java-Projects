import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class datacount{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("datacount".toLowerCase()+".dat"));
        while(f.hasNext()){
            char[] s = f.next().toCharArray();
            Arrays.sort(s);
            System.out.println(s);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new datacount().run();
    }
}
