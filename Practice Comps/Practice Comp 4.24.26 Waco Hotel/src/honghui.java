import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.function.DoublePredicate;

import static java.lang.Math.*;


public class honghui{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("honghui".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int N = f.nextInt();
            parenthesis = f.next();
            colors = new int[N];
            for (int i = 0; i < N; i++) colors[i] = f.nextInt();
            efforts = new int[N];
            for (int i = 0; i < N; i++) efforts[i] = f.nextInt();

            dp = new long[N][N];
            for (long[] each:dp) Arrays.fill(each, Long.MAX_VALUE);

            for (int i = 0; i < N; i++){
                dp[i][i] = efforts[i];
            }

            System.out.printf("Case #%d: %d\n", CASE, solve(0, N-1));

//            for (long[] each:dp) System.out.println(Arrays.toString(each));
        }

        f.close();
    }

    String parenthesis;
    int[] colors;
    int[] efforts;
    long[][] dp;

    public long solve(int start, int end){
        if (start > end) return 0;
        if (dp[start][end] != Long.MAX_VALUE) return dp[start][end];

        long res = Long.MAX_VALUE;

        if (parenthesis.charAt(start) == '(' && parenthesis.charAt(end) == ')' &&
            colors[start] == colors[end]){
            res = solve(start + 1, end-1);
        }

        for (int i = start; i < end; i++){
            res = Math.min(res, solve(start,i)+solve(i+1, end));
        }
        return dp[start][end] = res;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new honghui().run();
    }
}
