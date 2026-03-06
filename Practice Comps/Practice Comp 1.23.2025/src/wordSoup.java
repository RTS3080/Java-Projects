import java.util.*;
import java.io.*;

public class wordSoup{
    int maxLen;
    String str1;
    String str2;
    int[][] dp;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Soup".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            maxLen = 0;
            str1 = f.nextLine().replaceAll("\\s+","").toLowerCase();
            str2 = f.nextLine().replaceAll("\\s+","").toLowerCase();

            dp = new int[str1.length()][str2.length()];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.println(recur(0, 0));
        }
        f.close();
    }
    public int recur(int p1, int p2){
        if (p1 == str1.length() || p2 == str2.length()) return 0;
        if (dp[p1][p2] != -1) return dp[p1][p2];
        if (str1.charAt(p1) == str2.charAt(p2)) dp[p1][p2] = 1 + recur(p1 + 1, p2 + 1);
        return dp[p1][p2] = Math.max(dp[p1][p2], Math.max(recur(p1 + 1, p2), recur(p1, p2 + 1)));
    }


    public static void main(String[] args) throws FileNotFoundException{
        new wordSoup().run();
    }
}
