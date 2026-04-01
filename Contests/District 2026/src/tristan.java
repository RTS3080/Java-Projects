import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class tristan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tristan".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            String[] strs = f.nextLine().trim().split("\\s+");

            String[] line = f.nextLine().trim().split("\\s+");
            int[] costs = new int[line.length];
            for (int i = 0; i < line.length; i++) costs[i] = Integer.parseInt(line[i]);

            long[][] dp = new long[strs.length][2];
            for (long[] each : dp) Arrays.fill(each, Integer.MAX_VALUE);

            dp[0][0] = 0;
            dp[0][1] = costs[0];

            for (int i = 1; i < strs.length; i++){
                String curOrig = strs[i];
                String curRev = reverse(curOrig);
//
//                System.out.println(curOrig);
//                System.out.println(curRev);
//                System.out.println("-".repeat(10));

                String prevOrig = strs[i-1];
                String prevRev = reverse(prevOrig);
//
//                System.out.println(prevOrig);
//                System.out.println(prevRev);
//                System.out.println("-".repeat(10));

                long min = Integer.MAX_VALUE;
                if (curOrig.compareTo(prevOrig) >= 0) min = Math.min(min, dp[i-1][0]);
                if (curOrig.compareTo(prevRev) >= 0) min = Math.min(min, dp[i-1][1]);
                dp[i][0] = min;

                min = Integer.MAX_VALUE;
                if (curRev.compareTo(prevOrig) >= 0) min = Math.min(min, costs[i]+dp[i-1][0]);
                if (curRev.compareTo(prevRev) >= 0) min = Math.min(min, costs[i]+dp[i-1][1]);
                dp[i][1] = min;
            }

            long min = Math.min(dp[strs.length-1][0], dp[strs.length-1][1]);
            if (min >= Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(min);

//            for (long[] each : dp) System.out.println(Arrays.toString(each));

//            System.out.println(Arrays.deepToString(dp));
        }

        f.close();
    }

    public String reverse(String str){
        StringBuilder temp = new StringBuilder(str);
        return temp.reverse().toString();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tristan().run();
    }
}
