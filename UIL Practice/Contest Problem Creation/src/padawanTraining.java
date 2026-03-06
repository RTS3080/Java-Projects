import java.util.*;
import java.io.*;
import java.awt.*;

public class padawanTraining{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Student Data\\padawanTraining.dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            f.nextLine();
            int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                int a= i;
                int len = 1;
                while(a<nums.length-1 && nums[a]<nums[a+1]){
                    len++;
                    a++;
                }
                maxLen = Math.max(maxLen, len);
            }
            System.out.println(maxLen);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new padawanTraining().run();
    }
}
