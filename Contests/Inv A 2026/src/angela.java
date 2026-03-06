import java.util.*;
import java.io.*;
import java.awt.*;

public class angela{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("angela".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long a = f.nextLong();
            long b = f.nextLong();
            System.out.println(Math.abs(a - b));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new angela().run();
    }
}
