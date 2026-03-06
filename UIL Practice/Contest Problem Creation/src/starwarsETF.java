import java.util.*;
import java.io.*;
import java.awt.*;

public class starwarsETF{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("starwarsETF".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int m = f.nextInt();
            long[] nums = new long[m];
            for(int i=0;i<m;i++){
                nums[i]=f.nextLong();
            }
            long sum =0;
            int pointer = 1;
            int start =0;
            while(pointer<nums.length){
                if(nums[pointer] <nums[pointer-1]){
                    sum+=nums[pointer-1]-nums[start];
                    start=pointer;
                }
                pointer++;
            }
            if(nums[nums.length-1] >nums[start]){
                sum+=nums[nums.length-1]-nums[start];
            }
            System.out.println(sum > 0 ? sum : "This is not the trade you're looking for");
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new starwarsETF().run();
    }
}
