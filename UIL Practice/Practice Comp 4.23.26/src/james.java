import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class james{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("james".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int n = f.nextInt();
            int[] nums = Arrays.stream(f.next().split(",")).mapToInt(Integer::parseInt).toArray();

            int res = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++){
                min = Math.min(min, nums[i]);
                res  = Math.max(res, nums[i]-min);

//                System.out.println(min);
            }

            if (res == 0) System.out.println("99% of gamblers give up before winning big");
            else System.out.println(res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new james().run();
    }
}
