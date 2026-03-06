import java.util.*;
import java.io.*;
import java.awt.*;

public class moon{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("moon".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long n = f.nextLong();
            System.out.println(n>=1500 && n<=1800? "Failure is not an option.": "Houston, we have a problem.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new moon().run();
    }
}
