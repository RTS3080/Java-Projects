import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class lisa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lisa".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            String check = f.next();
            String revCheck = new StringBuilder(check).reverse().toString();

            int[][] dp = new int[check.length()+1][check.length()+1];
            int LCS = 0;

            for (int r = 1; r <= check.length(); r++){
                for (int c = 1; c <= check.length(); c++){
                    if (check.charAt(r-1) == revCheck.charAt(c-1)) dp[r][c] = dp[r-1][c-1]+1;
                    dp[r][c] = Math.max(dp[r][c], dp[r-1][c]);
                    dp[r][c] = Math.max(dp[r][c], dp[r][c-1]);
                    LCS = Math.max(dp[r][c], LCS);
                }
            }

//            for (int[] each : dp) System.out.println(Arrays.toString(each));

//            System.out.println(LCS);

            System.out.println(check.length() - LCS);
//
//            System.out.println(check);
//            System.out.println(revCheck);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lisa().run();
    }
}
