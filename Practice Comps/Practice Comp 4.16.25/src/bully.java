import java.util.*;
import java.io.*;

public class bully{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bully".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            int destroyed = 0;
            int tot = 0;
            int beet = f.nextInt();
            int cost = f.nextInt();
            while (beet > 0) {
                tot += beet;
                destroyed += beet;
                beet = destroyed / cost;
                destroyed = destroyed % cost;
            }
            System.out.println(tot);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bully().run();
    }
}
