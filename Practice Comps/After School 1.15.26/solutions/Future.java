import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Future {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("future.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			double l = file.nextDouble();
			double f = file.nextDouble();
			double n = file.nextDouble();
			double s = file.nextDouble();
			double w = file.nextDouble();
			double y = (s * l / f) + Math.pow(20 / f, w);
			y = l - Math.pow(f, n) * y / Math.pow(20, n);
			out.printf("%.2f%n", y);
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Future().run();
	}
}
