import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Everything {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("everything.dat"));
		int num = file.nextInt();
		file.nextLine();
		while(num-- > 0) {
			int n = file.nextInt(), t = file.nextInt(), r = file.nextInt();
			int[] times = new int[n], reeds = new int[n], univs = new int[n];
			String[] names = new String[n];
			for(int i = 0; i < n; i++) {
				names[i] = file.next();
				times[i] = file.nextInt();
				reeds[i] = file.nextInt();
				univs[i] = file.nextInt();
				file.nextLine();
			}
			printknapSack(t, r, times, reeds, univs, n, names);
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Everything().run();
	}
	
	 static void printknapSack(int T, int R, int times[], int reeds[], int univs[], int n, String[] names){
		int i, t, r;
		int K[][][] = new int[n + 1][T + 1][R + 1];
		for (i = 0; i <= n; i++) {
			for (t = 0; t <= T; t++) {
				for(r = 0; r <= R; r++) {
					if(i == 0 || t == 0 || r == 0)
						K[i][t][r] = 0;
					else if(reeds[i - 1] <= r && times[i - 1] <= t)
						K[i][t][r] = Math.max(univs[i - 1] + K[i - 1][t - times[i - 1]][r - reeds[i - 1]], K[i - 1][t][r]);
					else
						K[i][t][r] = K[i - 1][t][r];
				}
			}
		}
		int res = K[n][T][R];
		System.out.print(res + ": ");
		t = T;
		r = R;
		String s = "";
		for (i = n; i > 0 && res > 0; i--) {
			if (res == K[i - 1][t][r])
				continue;
			else {
				s += (names[i - 1] + " ");
				res = res - univs[i - 1];
				t = t - times[i - 1];
				r = r - reeds[i - 1];
			}
		}
		System.out.println(s.trim());
	}
}
