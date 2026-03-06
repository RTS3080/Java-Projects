import java.util.*;
import java.io.*;
import java.awt.*;

public class honeymoon{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("honeymoon".toLowerCase()+".dat"));

        int[] passes = new int[]{1, 5, 10, 30};
        int cases = f.nextInt();
        while(cases-->0){
            int[] prices = new int[4];
            for(int i=0; i<4; i++){
                prices[i] = f.nextInt();
            }
            f.nextLine();

            String[] line = f.nextLine().trim().split("\\s+");
            int[]  days = new int[line.length+1];
            days[0] = -100;
            for(int i=1; i<line.length+1; i++){
                days[i] = Integer.parseInt(line[i-1]);
            }

            int[] dp = new int[days.length];
            for (int i = 1; i < dp.length; i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < 4; j++){
                    int ind = i;
                    int lastDayCovered = days[i] - (passes[j]-1);
                    while (ind >= 0 && days[ind] >= lastDayCovered) ind--;
                    temp = Math.min(temp, dp[ind]+prices[j]);
                }
                dp[i] = temp;
            }

            System.out.println(dp[dp.length-1]);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new honeymoon().run();
    }
}
