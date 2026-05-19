import java.io.*;
import java.util.*;
import java.math.*;
public class bus {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("bus.dat"));
		while(file.hasNextLine()) {
			file.next();
			int bn = file.nextInt(); file.nextLine();
			long[][] br = new long[bn][];
			long[] sums = new long[bn];
			for(int i = 0; i < bn; i++) {
				br[i] = Arrays.stream(file.nextLine().split(" ")).mapToLong(x -> Long.parseLong(x)).toArray();
				for(long j : br[i]) sums[i] += j;
			}
			long time = file.nextLong();
			file.nextLine();
			file.nextLine();
			long max = -1;
			for(int i = 0; i < bn; i++) {
				long cur = -(time % sums[i]);
				int index = 0;
				while(cur < 0) {
					if(index == br[i].length) index = 0;
					cur += br[i][index++];
				}
				if(max == -1 || max > cur) max = cur;
			}
			System.out.println(max);
			
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new bus().run();
	}
}
