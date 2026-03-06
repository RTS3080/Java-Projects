import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class noco{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("noco".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();
            int M = f.nextInt();
            A = f.nextInt();
            B = f.nextInt();
            C = f.nextInt();

            str1 = f.next();
            str2 = f.next();

            dp = new long[str1.length()+1][str2.length()+1];
            for (long[] each : dp) Arrays.fill(each, Long.MIN_VALUE);

            for (int r = 0; r < dp.length; r++){
                dp[r][0] = (long) -C * r;
            }
            for (int c = 0; c < dp[0].length; c++){
                dp[0][c] = (long) -C * c;
            }

            System.out.println(recur(str1.length(), str2.length()));
//            System.out.println(recur(1, 2));

//            for (long[] each:dp) System.out.println(Arrays.toString(each));
        }

        f.close();
    }

    long[][] dp;
    String str1, str2;

    int A, B, C;

    public long recur(int ind1, int ind2){
        if (dp[ind1][ind2] != Long.MIN_VALUE) return dp[ind1][ind2];

        long temp = Long.MIN_VALUE;

        if (str1.charAt(ind1-1) == str2.charAt(ind2-1)){
            temp = Math.max(temp, recur(ind1-1, ind2-1)+A);
        }
        else{
            temp = Math.max(temp, recur(ind1-1, ind2-1)-B);
            temp = Math.max(temp, recur(ind1-1, ind2)-C);
            temp = Math.max(temp, recur(ind1, ind2-1)-C);
        }

        return dp[ind1][ind2] = temp;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new noco().run();
    }
}
