import java.util.*;
import java.io.*;

public class optimise{

    int[] dp;
    int[] vals;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("optimize".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            vals = Arrays.stream(ln.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int len = f.nextInt(); f.nextLine();
            dp = new int[len+1];
            System.out.println(recur(len));
        }
        f.close();
    }

    int recur(int len){
        if(dp[len]!=0) return dp[len];
        int max =0;
        for(int i = 0; i< Math.min(vals.length, len);i++){
            max = Math.max(max, recur(len-i-1)+vals[i]);
        }
        dp[len]=max;
        return max;

    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new optimise().run();
    }
}
