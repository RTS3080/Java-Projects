import java.util.*;
import java.io.*;

public class vanessa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vanessa".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();

        while(cases-- > 0){
            int[] nums = Arrays.stream(f.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int target = f.nextInt();

            int[] dp = new int[target+1];
//            Arrays.fill(dp, 1);
            dp[0] = 1;
            for (int r = 0; r < nums.length; r++){
                int[] copy = Arrays.copyOf(dp, dp.length);
                for (int c = 0; c < target+1; c++){
                    if (c-nums[r] >= 0){
                        copy[c] = Math.max(copy[c], copy[c-nums[r]]+dp[c]);
                    }
                }
                dp = copy;
            }

            System.out.println(dp[target]);
            f.nextLine();
            f.nextLine();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vanessa().run();
    }
}
