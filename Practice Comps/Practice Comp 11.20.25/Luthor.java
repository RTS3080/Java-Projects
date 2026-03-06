import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Luthor {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("luthor.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int s = file.nextInt(), lex = file.nextInt(), opt = 0;
			file.nextLine();
			while(s-- > 0) {
				String[] str = file.nextLine().trim().split(" ");
				int[] nums = new int[str.length];
				for(int i = 0; i < str.length; i++)
					nums[i] = Integer.parseInt(str[i]);
				opt += maxProfit(nums, nums.length);
			}
			//System.out.println(opt);
			System.out.println(opt <= lex? "Lexcellent": "Metro-boring-olis");
		}
	}
	
    int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0;
        int[][] curr = new int[k+1][2];
        int[][] next = new int[k+1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int l = 1; l <= k; l++) {
                curr[l][1] = Math.max(-prices[i] + next[l][0], next[l][1]);
                curr[l][0] = Math.max(prices[i] + next[l-1][1], next[l][0]);
            }
            for (int l = 0; l <= k; l++) {
                next[l][0] = curr[l][0];
                next[l][1] = curr[l][1];
            }
        }
        return curr[k][1]; 
    }
	
	public static void main(String[]args)throws Exception{
		new Luthor().run();
	}
}
