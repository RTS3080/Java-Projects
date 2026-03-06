import java.util.*;
import java.io.*;
import java.awt.*;

public class duck{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("duck".toLowerCase()+".dat"));
        int times = f.nextInt();
        long seed = f.nextLong();
        Random r = new Random(seed);
        int[] levels = new int[4];
        while(times-->0){
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum+=r.nextInt(1, 11);
            }
            if(sum <=25)levels[0]++;
            else if(sum <=30)levels[1]++;
            else if(sum <=35)levels[2]++;
            else levels[3]++;
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println("Level "+i+": "+levels[i-1]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new duck().run();
    }
}
