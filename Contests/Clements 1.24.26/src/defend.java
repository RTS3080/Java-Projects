import java.util.*;
import java.io.*;

public class defend{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("defend".toLowerCase()+".in"));

        int cases = f.nextInt();
        while(cases-- >0){
            int N = f.nextInt();
            int health = f.nextInt();

            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = f.nextInt();
            int[] b = new int[N];
            for (int i = 0; i < N; i++) b[i] = f.nextInt();

//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(b));

            int[] dp = new int[health];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for (int i = 0; i < N; i++){
                for (int j = health-1; j >= 0; j--){
                    if (dp[j] != -1) {
                        if (j + a[i] < dp.length) dp[j + a[i]] = Math.max(dp[j + a[i]], dp[j] + b[i]);
                    }
                }
            }

            int result = 0;
            for (int each : dp) result = Math.max(result, each);

            System.out.println(result);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new defend().run();
    }
}
