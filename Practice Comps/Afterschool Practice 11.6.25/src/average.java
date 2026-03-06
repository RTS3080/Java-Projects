import java.util.*;
import java.io.*;
import java.awt.*;

public class average{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("average".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double[] nums = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] *=nums[i];
                sum+=nums[i];
            }
            sum/=nums.length;
            System.out.printf("%.3f\n", Math.sqrt(sum));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new average().run();
    }
}
