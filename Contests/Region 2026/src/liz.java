import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class liz{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("liz".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));


       int cases = f.nextInt();
       while (cases-- > 0){
           String test = f.next();
           String rev = new StringBuilder(test).reverse().toString();

           int[][] dp = new int[test.length()+1][test.length()+1];
           for (int r = 1; r <= test.length(); r++){
               for (int c = 1; c <= test.length(); c++){
                   if (test.charAt(r-1) == rev.charAt(c-1)){
                       dp[r][c] = dp[r-1][c-1] + 1;
                   }
                   dp[r][c] = Math.max(dp[r][c], Math.max(dp[r-1][c], dp[r][c-1]));
               }
           }

//           for (int[] each:dp) System.out.println(Arrays.toString(each));

           int res = test.length() - dp[test.length()][test.length()];
           System.out.println(res);
       }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new liz().run();
    }
}
