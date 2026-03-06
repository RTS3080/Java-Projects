import java.util.*;
import java.io.*;
import java.awt.*;

public class DryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("DryRun".toLowerCase()+".dat"));
//        Scanner f= new Scanner(System.in);
        int times=f.nextInt();
        while(times-->0){
            System.out.println("I like "+f.next()+".");
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new DryRun().run();
    }
}
