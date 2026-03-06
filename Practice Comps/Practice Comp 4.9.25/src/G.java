import java.util.*;
import java.io.*;

public class G{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("G"+".txt"));

        int cases = f.nextInt();
        f.nextLine();
        for (int CASE = 1; CASE <= cases; CASE++){
            String test = f.nextLine().strip();
            int[][] dp = new int[test.length()][test.length()];
            for (int start = test.length()-1; start >= 0; start--){
                dp[start][start] = 1;
                for (int end = start+1; end < test.length(); end++){
                    if (test.charAt(start) == test.charAt(end)){
                        dp[start][end] = dp[start+1][end-1]+2;
                    }
                    else{
                        dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
                    }
                }
            }

            System.out.print("Problem "+CASE+": ");
            if (dp[0][test.length()-1] == test.length()) System.out.println("This is a palindrome");
            else if (test.length()-dp[0][test.length()-1] == 1) System.out.println("Close enough to a palindrome");
            else System.out.println("Can't form a palindrome");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new G().run();
    }
}
