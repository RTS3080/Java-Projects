import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Kara {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("kara.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int a = file.nextInt();
			int b = file.nextInt();
			int c = file.nextInt();
			int d = file.nextInt();
			System.out.println((d - a) - (c - b));
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Kara().run();
	}
}
