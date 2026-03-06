import java.util.*;
import java.io.*;
import java.awt.*;

public class dryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryRun".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println("Thank you for your hard work, "+f.next()+"!");
        }
        System.out.println("Thank you for your hard work, Mrs. Lorena!");
        System.out.println("Thank you for your hard work, Mr. Fugel!");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryRun().run();
    }
}
