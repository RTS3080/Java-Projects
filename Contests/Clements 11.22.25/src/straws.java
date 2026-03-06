import java.util.*;
import java.io.*;
import java.awt.*;

public class straws{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("straws".toLowerCase()+".dat"));
        int N = f.nextInt();
        int M = f.nextInt();

        int[] cuts = new int[M];
        for(int i = 0; i < M; i++){
            cuts[i] = f.nextInt();
        }

        int max = 0;
        int[] targets = new int[N];
        for(int i = 0; i < N; i++){
            targets[i] = f.nextInt();
            max = Math.max(max, targets[i]);
        }

        long[] dp = new long[max+1];
        for (int i = 0; i <= max; i++){
            long temp = 0;
            for (int j = 0; j < M; j++) {
                int len = j+1;
                if (i - len < 0) break;
                temp = Math.max(temp, dp[i - len] + cuts[j]);
            }
            dp[i] = temp;
        }
        for (int each:targets){
            System.out.println(dp[each]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new straws().run();
    }
}
