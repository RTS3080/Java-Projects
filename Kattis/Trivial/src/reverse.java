import java.util.*;
import java.io.*;

public class reverse{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("reverse".toLowerCase()+".dat"));
        Scanner f = new Scanner(System.in);
        int a = f.nextInt();
        int[] nums = new int[a];
        for (int i = 0; i < a; i++) {
            nums[i] = f.nextInt();
        }
        for (int i = a-1;i>=0;i--) {
            System.out.println(nums[i]);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new reverse().run();
    }
}
