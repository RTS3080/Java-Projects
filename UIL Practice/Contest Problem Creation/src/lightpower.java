import java.util.*;
import java.io.*;
import java.awt.*;

public class lightpower{
    int goal;
    int[] dp;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lightpower".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            goal = f.nextInt();
            dp = new int[goal*3];
            Arrays.fill(dp,Integer.MAX_VALUE/4);
            System.out.println(recur(new int[]{5,5,5}, 0));
        }

        f.close();
    }
    int recur(int[] gear, int time){
        int pow = gear[0]+gear[1]+gear[2];

        if((pow/3)>=goal){
            return time;
        }
        if(dp[pow]<=time){
            return dp[pow];
        }
        for (int i = 0; i < 3; i++) {
            if(gear[i]>100) return 0;
        }
        int minInd = 0, midInd = 0, maxInd = 0;
        for (int i = 0; i < 3; i++) {
            if(gear[i]>gear[maxInd]){
                maxInd = i;
            }
            if(gear[i]<gear[minInd]){
                minInd = i;
            }
            if(i!=minInd && i!=maxInd){
                midInd = i;
            }
        }
//        System.out.println(minInd+" "+midInd+" "+maxInd);
        int[] strike = Arrays.copyOf(gear, 3);
        strike[minInd]+=5;
        strike[midInd]+=5;

        int[] crucible = Arrays.copyOf(gear, 3);
        crucible[minInd]+=8;

        for (int i = 0; i < 3; i++) {
            gear[i] +=3;
        }
        return dp[pow] = Math.min(recur(strike, time+4), Math.min(recur(crucible, time+3), recur(gear, time+6)));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lightpower().run();
    }
}
