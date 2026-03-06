import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class probB{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("probB".toLowerCase()+".in"));
        int numTimes=f.nextInt();
        for(int times = 0; times < numTimes; times++){
            double[] nums = Arrays.stream(f.next().split(":")).mapToDouble(Double::parseDouble).toArray();
            double velo = nums[0];
            double dist = nums[1];
            if(velo >= dist){
                System.out.println("SWERVE");
            }
            else if(velo * 5 >= dist){
                System.out.println("BRAKE");
            }
            else{
                System.out.println("SAFE");
            }
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new probB().run();
    }
}
