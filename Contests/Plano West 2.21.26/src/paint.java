import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class paint{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("paint".toLowerCase()+".in"));
        long area = f.nextLong() * 3;
        long size = f.nextLong();
        System.out.println(size >= area ? "Yay, colors" : "Cloud duck");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new paint().run();
    }
}
