import java.util.*;
import java.io.*;

public class timothy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("timothy".toLowerCase()+".dat"));
        int[] nums = new int[50];
        Arrays.fill(nums,-1);
        while(f.hasNext()){
            nums[f.nextInt()]++;
        }
        for(int i = 49;i>=0;i--){
            if(nums[i]==0){
                System.out.println(i);
            }
            else if(nums[i]<0){
            }
            else{
                System.out.println(i+" "+nums[i]);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new timothy().run();
    }
}
