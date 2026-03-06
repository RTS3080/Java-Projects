import java.util.*;
import java.io.*;
import java.awt.*;

public class diane{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diana".toLowerCase()+".dat"));
        while(f.hasNext()) {
            double[] nums = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double x = nums[0] - nums[3];
            double y = nums[1] - nums[4];
            double z = nums[2] - nums[5];
            double d = Math.sqrt(x * x + y * y + z * z);
            System.out.printf("%.2f\n", d);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new diane().run();
    }
}
