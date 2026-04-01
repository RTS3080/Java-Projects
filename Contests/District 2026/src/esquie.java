import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class esquie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("esquie".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double[] nums = Arrays.stream(f.nextLine().split(":")).mapToDouble(Double::parseDouble).toArray();
            nums[0]%=12;
            nums[1]%=60;
            double minuteDegree = nums[1] * 6;
            double hourDegree = nums[0] /12 * 360;
            hourDegree += minuteDegree/12;
            minuteDegree= (360 - (hourDegree-minuteDegree))%360;
            System.out.printf("%05.1f:%05.1f\n", hourDegree, minuteDegree);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new esquie().run();
    }
}
