import java.util.*;
import java.io.*;

public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryrun".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine().trim() + " likes playing football.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
