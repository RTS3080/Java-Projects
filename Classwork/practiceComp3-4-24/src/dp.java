import java.util.*;
import java.io.*;

public class dp{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("cash".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int num=f.nextInt();
            int cost=f.nextInt();
            int[] coins=new int[cost];
            for (int i = 0; i < num; i++) {
                coins[i]=f.nextInt();
            }
            boolean[] dp=new boolean[cost+1];
            dp[0] = true;
            for(int i:coins){
                for (int j = cost; j-i>-1;j--) {
                    if(dp[j-i]) {
                        dp[j] = true;
//                        System.out.println(j+" "+i);
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
            for (int i = 0; i < dp.length; i++) {
                System.out.println(i+": "+dp[i]);
            }
//            System.out.println();
            System.out.println(cost+" is "+(dp[cost]?"possible":"not possible"));
        }
        f.close();
    }
}
