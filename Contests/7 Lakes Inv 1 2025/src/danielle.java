import java.util.*;
import java.io.*;

public class danielle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("danielle".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().trim().split(",");
            int[] nums = new int[ln.length];
            for(int i=0;i<ln.length;i++){
                nums[i]=Integer.parseInt(ln[i]);
            }
            int sum = 0;
            for (int i = 1; i <= nums.length; i++) {
                int a = nums[i-1]-i;

                a*=Math.pow(10,i-1);
                System.out.print(a+" ");
                sum+=a;
            }
            System.out.println();
            System.out.println(sum);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new danielle().run();
    }
}
