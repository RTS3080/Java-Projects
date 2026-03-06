import java.util.*;
import java.io.*;
import java.awt.*;

public class practice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("practice".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0){
            test = f.nextLine().trim();

            dp = new int[test.length()][test.length()];
            for (int[] each : dp) Arrays.fill(each, Integer.MAX_VALUE);

            if (test.isEmpty()) System.out.println("1");
            else System.out.println(recur(0, test.length()-1));
        }

        f.close();
    }

    String test;
    int[][] dp;

    public int recur(int start, int end){
        if (start >= end) return 0;
        if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];

        int temp = Integer.MAX_VALUE;

        if (test.charAt(start) == test.charAt(end))
            temp = Math.min(temp, recur(start+1, end-1));

        temp = Math.min(temp, recur(start + 1, end) + 1);
        temp = Math.min(temp, recur(start, end - 1) + 1);

        return dp[start][end] = temp;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new practice().run();
    }
}
