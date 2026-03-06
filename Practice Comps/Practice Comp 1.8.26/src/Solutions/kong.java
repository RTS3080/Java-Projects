package Solutions;

import java.util.*;
import java.io.*;
public class kong {
    public static void main(String[] args) throws Exception {
        new kong().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("kong.dat"));
//         Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.next();
            String pal = ln.substring(0,ln.length()/2);
            if(ln.length() % 2 == 1){
                pal += ln.charAt(ln.length()/2);
            }
            pal += new StringBuilder(ln.substring(0,ln.length()/2)).reverse().toString();
            int n = ln.length();
            int m = pal.length();
            String[][] dp = new String[n+1][m+1];
            for(int i = 0;i<=n;i++){
                for(int j =0;j<=m;j++){
                    if(i==0||j==0) dp[i][j] = "";
                    else if (ln.charAt(i - 1) == pal.charAt(j - 1)) {
                        dp[i][j] = dp[i-1][j-1] + ln.charAt(i-1);
                    }
                    else {
                        if(dp[i][j-1].length()>dp[i-1][j].length()){
                            dp[i][j] = dp[i][j-1];
                        }
                        else dp[i][j] = dp[i-1][j];
                    }
                }
            }
            System.out.println(n-dp[n][m].length());
        }
        f.close();
    }
}