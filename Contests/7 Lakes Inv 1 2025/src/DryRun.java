import java.util.*;
import java.io.*;

public class DryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("DryRun".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println("I like "+f.nextLine().trim()+".");
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException{
        new DryRun().run();
    }
}
