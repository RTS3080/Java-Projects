import java.util.*;
import java.io.*;
import java.awt.*;

public class Harry{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Harry".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String str= f.next();
            String take = f.next();
            String s = str.replaceAll("["+take.toLowerCase()+take.toUpperCase()+"]", "");
            if(s.isEmpty()) System.out.println("ALL LETTERS ARE GONE");
            else System.out.println(s);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Harry().run();
    }
}
