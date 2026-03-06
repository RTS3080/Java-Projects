import java.util.*;
import java.io.*;

public class encryption{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("encryption".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split("");
            int[] nums = new int[ln.length];
            for(int i = 0; i < ln.length; i++){
                nums[i] = (Integer.parseInt(ln[i])+7)%10;
            }
            for (int i = 1; i <= nums.length; i++) {
                if(i%4 == 0){
                    int first = nums[i-4];
                    int second = nums[i-3];
                    int third = nums[i-2];
                    int fourth = nums[i-1];
                    nums[i-1] = second;
                    nums[i-4] = third;
                    nums[i-2] = first;
                    nums[i-3] = fourth;
//                    System.out.println(i+ " "+ first +" "+second+" "+third+" "+fourth);
                }
            }
            for(int i : nums){
                System.out.print(i);
            }
            System.out.println();
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new encryption().run();
    }
}
