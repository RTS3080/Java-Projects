import java.util.*;
import java.io.*;

public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("drybones".toLowerCase()+".dat"));
        System.out.println(f.nextInt()*f.nextInt());
        System.out.println("I'm gonna get so much candy!");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
