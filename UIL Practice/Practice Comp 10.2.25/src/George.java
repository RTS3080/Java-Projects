import java.util.*;
import java.io.*;
import java.awt.*;

public class George{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("George".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int mpg = f.nextInt();
            int gals = f.nextInt();
            int dist = f.nextInt();
            System.out.println(mpg * gals >=dist?"Never tell me the odds." : "I've got a bad feeling about this.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new George().run();
    }
}
