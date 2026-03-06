import java.util.*;
import java.io.*;
import java.awt.*;

public class Christine{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Christine".toLowerCase()+".dat"));
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i]=f.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            int change = (int)Math.signum(-nums[i]+nums[i+1]);
            int a = nums[i];
            String s= "";
//            System.out.println(change);
            while(a!=nums[i+1]){
                s+=a+" ";
                a+=change;
            }
            s+=a;
            System.out.println(s.trim());
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Christine().run();
    }
}
