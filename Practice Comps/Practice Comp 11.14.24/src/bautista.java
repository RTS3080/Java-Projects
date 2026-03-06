import java.util.*;
import java.io.*;

public class bautista{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bautista".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine().replaceAll("[aeiou]","OUCH!!!"));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bautista().run();
    }
}
