import java.util.*;
import java.io.*;
import java.awt.*;

public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dryrun".toLowerCase()+".in"));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
