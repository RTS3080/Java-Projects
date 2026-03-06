import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Battleworld {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("battleworld.dat"));
		LinkedHashMap<String, Character> legend = new LinkedHashMap<String, Character>();
		char[] lis = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int times = file.nextInt(), curr = 0;
		file.nextLine();
		while(times-- > 0) {
			int r = file.nextInt(), c = file.nextInt(), e = file.nextInt();
			char[][] mat = new char[r][c];
			for(int rr = 0; rr < r; rr++)
				Arrays.fill(mat[rr], '.');
			while(e-- > 0) {
				String name = file.next();
				if(!legend.containsKey(name))
					legend.put(name, lis[curr++]);
				char f = legend.get(name);
				int r1 = file.nextInt(), c1 = file.nextInt(), r2 = file.nextInt(), c2 = file.nextInt();
				file.nextLine();
				for(int i = r1; i <= r2; i++)
					for(int j = c1; j <= c2; j++)
						mat[i][j] = f;
			}
			for(char[] k:mat)
				System.out.println(k);
			System.out.println("----------");
		}
		System.out.println(legend.toString().replaceAll("[\\{\\} ]+","").replace(",","\n"));
	}
	
	public static void main(String[]args)throws Exception{
		new Battleworld().run();
	}
}
