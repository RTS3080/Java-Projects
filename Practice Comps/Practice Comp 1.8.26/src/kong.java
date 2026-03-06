import java.util.*;
import java.io.*;
import java.awt.*;

public class kong{

    String check;
    int[][] dp;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kong".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            check = f.next();

            dp = new int[check.length()][check.length()];

            for (int[] each:dp) Arrays.fill(each, Integer.MAX_VALUE);
            System.out.println(recur(0, check.length()-1, 0));

            for (int[] each:dp) System.out.println(Arrays.toString(each));;
        }

        f.close();
    }

    public int recur(int left, int right, int cur){

        if (left >= right || left >= check.length() || right < 0){
            if (left < check.length() && right >= 0 && dp[left][right] > cur){
                return dp[left][right] = cur;
            }
            return cur;
        }

        if (dp[left][right] != Integer.MAX_VALUE) return dp[left][right];

        if (check.charAt(left) == check.charAt(right)){
            return dp[left][right] = recur(left + 1, right - 1, cur);
        }
        int check = recur(left + 1, right, cur + 1);
        check = Math.min(check, recur(left, right - 1, cur + 1));
        check = Math.min(check, recur(left + 1, right - 1, cur +  1));

        return dp[left][right] = check;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new kong().run();
    }
}
