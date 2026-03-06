import java.util.*;
import java.io.*;

public class team{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("team".toLowerCase()+".in"));

        int N = f.nextInt();
        int Q = f.nextInt();

        int[] healths = new int[N];
        for (int i = 0; i < N; i++) healths[i] = f.nextInt();

        int max = 0;
        int[] queries = new int[Q];

        for (int i = 0; i < Q; i++){
            queries[i] = f.nextInt();
            max = Math.max(max, queries[i]);
        }

        boolean[] dp = new boolean[max+1];
        dp[0] = true;

        for (int health:healths){
            for (int i = max; i >= 0; i--){
                if (dp[i] && i+health <= max){
                    dp[i+health] = true;
                }
            }
        }

        for (int each:queries){
            System.out.println(dp[each] ? "YES" : "NO");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new team().run();
    }
}
