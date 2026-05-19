import java.io.*;
import java.util.*;
import java.math.*;
public class cd {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("cd.dat"));
		while(file.hasNext()) {
			double d = file.nextDouble();
			double r = 700-d%700;
			if (d == 0) r = 0;
			System.out.printf("%d - %.1f%n",(int)(Math.ceil(d/700)),r);
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new cd().run();
	}
}
