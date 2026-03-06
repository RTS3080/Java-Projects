import java.util.*;
import java.io.*;
import java.awt.*;

public class spray{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spray".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            String[] line = f.nextLine().split(" ");
            int[] arr = new int[line.length];

            for (int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(line[i]);
            }

            int[] dp = new int[arr.length];

            int max = 0;

            for (int i = 0; i < arr.length; i++){
                dp[i] = Math.max( (i-2 >= 0 ? dp[i-2] : 0) + arr[i], (i-1 >= 0 ? dp[i-1] : 0));
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new spray().run();
    }
}
