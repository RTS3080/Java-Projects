import java.util.*;
import java.io.*;

public class longwalk{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("longwalk".toLowerCase()+".dat"));

        int times=f.nextInt();
        while(times-->0){
            f.nextLine();
            String street = f.nextLine().trim();
            int houses = f.nextInt();
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < houses; i++) {
                int h = f.nextInt();
                min = Math.min(min, h);
                max = Math.max(max, h);
            }

            System.out.println("The two houses furthest apart on " + street + " are");
            System.out.println(min + " " + street + " and " + max + " " + street);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new longwalk().run();
    }
}
