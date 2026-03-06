import java.util.*;
import java.io.*;
import java.awt.*;

public class MiningMadness{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("MiningMaximum".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long max = f.nextLong(); f.nextLine();
            long sum = 0;
            int cnt = 0;
            long[] nums = Arrays.stream(f.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            for(int i=0; i<nums.length; i++){
                sum+=nums[i];
                if(sum>max){
                    break;
                }
                cnt++;
            }
            System.out.println(cnt);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new MiningMadness().run();
    }
}
