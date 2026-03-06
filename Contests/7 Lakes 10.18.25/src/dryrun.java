import java.util.*;
import java.io.*;

public class dryrun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            String line = f.nextLine().trim();
            System.out.println("Hey "+line+", our glorious leader has been deposed!");
        }

        // 

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dryrun().run();
    }
}
