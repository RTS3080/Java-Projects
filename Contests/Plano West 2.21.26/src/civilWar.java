import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class civilWar{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("civilWar".toLowerCase()+".in"));
        int len = f.nextInt();
        long[] nums = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = f.nextLong();
            sum += nums[i];
        }
        long minDiff = Long.MAX_VALUE;
        long left = 0;
        long right = sum;
        for (int i = 0; i < len; i++) {
            long diff = abs(right - left);
            minDiff = Math.min(minDiff, diff);
            right -= nums[i];
            left+=nums[i];
        }
        System.out.println(minDiff);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new civilWar().run();
    }
}
