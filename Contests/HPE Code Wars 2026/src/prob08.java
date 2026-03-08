import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob08{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob08".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String ln = f.nextLine();
        int count = 0;
        while(f.hasNext()){
            String s = f.nextLine();
            if(s.equals(".")){ break;}
            if(!s.equals(ln)){
                System.out.println(s);
                count++;
            }
        }
        System.out.println("Number of incorrect lines: "+count);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob08().run();
    }
}
