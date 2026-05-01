import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Wojtek{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Wojtek".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            while(!allZero(nums)){
                int[] diffs = new int[4];
                for (int i = 0; i < nums.length-1; i++) {
                    diffs[i] = abs(nums[i] - nums[i+1]);
                }
                diffs[3] = abs(nums[nums.length-1] - nums[0]);
                count++;
                System.arraycopy(diffs, 0, nums, 0, 4);
            }
            System.out.println("Case #"+times+": "+count);
        }
        f.close();
    }

    boolean allZero(int[] nums){
        for(int num : nums){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Wojtek().run();
    }
}
