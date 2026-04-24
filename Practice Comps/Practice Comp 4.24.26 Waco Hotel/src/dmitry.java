import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class dmitry{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dmitry".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(nums);
            for(int n : nums){
                System.out.println("X".repeat(n));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dmitry().run();
    }
}
