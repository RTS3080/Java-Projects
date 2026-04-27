import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jawbreakers{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jawbreakers".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0) {
            int jawbreakers = f.nextInt();
            int floors = f.nextInt();

            dp = new int[jawbreakers+1][floors+1];
            for (int[] each:dp) Arrays.fill(each, -1);

            System.out.println(solve(jawbreakers, 0, floors));

            for (int[] each:dp) System.out.println(Arrays.toString(each));
        }

        f.close();
    }

    int[][] dp;

    public int solve(int jawbreakers, int min, int max){
        if (jawbreakers == 1) return max - min;
        if (min == max) return 0;
        if (max == 1) return 1;
        if (dp[jawbreakers][max] != -1) return dp[jawbreakers][max];
        int res = max - min;
        for (int i = min+1; i < max; i++){
            int ifBreak = solve(jawbreakers-1, min, i)+1;
            int ifNotBreak = solve(jawbreakers, i, max)+1;
            res = Math.min(res, Math.max(ifBreak, ifNotBreak));
        }
        System.out.println(res);
        return dp[jawbreakers][max] = res;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jawbreakers().run();
    }
}
