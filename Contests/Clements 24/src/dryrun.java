import java.util.*;
import java.io.*;

public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryrun".toLowerCase()+".in"));
        System.out.println("Timothy, Victoria, and Katherine said: ");
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
