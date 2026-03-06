import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class World {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("world.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int m = 1000 * file.nextInt();
			int e = file.nextInt() / 1000;
			int s = file.nextInt() + file.nextInt() + file.nextInt();
			int num = 0;
			while(m - 50 >= 0 && e - 12 >= 0 && s > 0) {
				num++;
				s--;
				e -= 12;
				m -= 50;
			}
			System.out.println(num);
		}
	}
	
	public static void main(String[]args)throws Exception{
		new World().run();
	}
}
