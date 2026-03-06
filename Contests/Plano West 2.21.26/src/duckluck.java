import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class duckluck{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("duckluck".toLowerCase()+".in"));
        long left = f.nextLong();
        long right = f.nextLong();
        long dist = right - left + 1;
        long W = f.nextLong();

        System.out.println((int) (W / Math.floor(Math.log(dist) / Math.log(2) + 1)));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new duckluck().run();
    }
}
