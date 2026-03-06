import java.util.*;
import java.io.*;
import java.awt.*;

public class dryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryRun".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println("I like "+f.next()+".");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryRun().run();
    }
}
