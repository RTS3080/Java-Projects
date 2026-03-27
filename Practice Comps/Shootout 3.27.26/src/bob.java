import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bob{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bob".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            long[] nums = Arrays.stream(f.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(nums);
            System.out.println(nums[0] * nums[1] + nums[2] + nums[3]*nums[4]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bob().run();
    }
}
