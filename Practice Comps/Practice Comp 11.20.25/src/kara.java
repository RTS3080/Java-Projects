import java.util.*;
import java.io.*;
import java.awt.*;

public class kara{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kara".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long a = f.nextLong();
            long b = f.nextLong();
            long c = f.nextLong();
            long d = f.nextLong();
            System.out.println((d-a)-(c-b));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kara().run();
    }
}
