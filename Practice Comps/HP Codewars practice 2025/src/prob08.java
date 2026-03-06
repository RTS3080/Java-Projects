import java.util.*;
import java.io.*;

public class prob08{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob08".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double[] nums = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            String a = "";
            for(int i=0; i<nums.length; i++){
                double n = nums[i];
                n-=180;
                if(n<0){
                    n = 360+n;
                }
                a+=String.format("%06.2f ", n);
            }
            System.out.println(a.trim());
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new prob08().run();
    }
}
