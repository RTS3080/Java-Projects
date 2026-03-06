import java.util.*;
import java.io.*;
import java.awt.*;

public class vanessa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vanessa".toLowerCase()+".dat"));

        int t = f.nextInt();
        f.nextLine();

        while(t-- > 0){
            String[] line = f.nextLine().split(",");
            int[] arr = new int[line.length];
            for (int i = 0; i < line.length; i++){
                arr[i] = Integer.parseInt(line[i]);
            }

            int target = f.nextInt();
            f.nextLine();
            f.nextLine();


            int[] dp = new int[target+1];

            dp[0] = 1;
            for (int each:arr){
                for (int i = 0; i <= target; i++) {
                    if (i+each <= target) {
                        dp[i + each] += dp[i];
                    }
                }


            }

            System.out.println(dp[target]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vanessa().run();
    }
}
