import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ronaldo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ronaldo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            target = f.nextInt();
            maxCons = f.nextInt();

            dp = new long[target+1][4][maxCons+1];

            for (int i = 0; i < target+1; i++){
                for (int j = 0; j < 4; j++){
                    for (int k = 0; k < maxCons+1; k++){
                        dp[i][j][k] = -1;
                    }
                }
            }

            long result = 0L;

            for (int i = 1; i <= 3; i++)
                for (int j = 0; j <= maxCons; j++)
                    result = (result + recur(2, i, j))%MOD;

//            System.out.println(result);
//
            for (int i = 0; i < dp.length; i++){
                System.out.println("TARGET: "+i);
                for (int j = 0; j < dp[i].length; j++){
                    System.out.print("GOALS: "+j);
                    System.out.println(Arrays.toString(dp[i][j]));
                }
                System.out.println("-".repeat(10));
            }
            System.out.println("=".repeat(10));

            System.out.println(result);

        }

        f.close();
    }

    int target;
    int maxCons;
    long[][][] dp;

    long MOD = 1_000_000_007L;

    public long recur(int score, int goal, int cons){
        if (cons > maxCons) return 0;
        if (score < 0) return 0;
        if (score == 0) return dp[score][goal][cons] = 1;
        if (dp[score][goal][cons] != -1) return dp[score][goal][cons];

        long temp = 0L;
        for (int i = 1; i <= 3; i++){
            temp += recur(score-i, i, (goal == i ? cons+1 : 0));
        }
        return dp[score][goal][cons] = temp % MOD;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new ronaldo().run();
    }
}
