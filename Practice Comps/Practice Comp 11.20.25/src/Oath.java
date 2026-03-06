import java.util.*;
import java.io.*;
import java.awt.*;

public class Oath{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Oath".toLowerCase()+".dat"));
        while(f.hasNext()){
            long a = f.nextLong();
            for (int i = 0; i < a; i++) {
                System.out.println(a+" MEAN GREEN");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Oath().run();
    }
}
