import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Thing {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("thing.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String s = file.nextLine().trim();
			if(s.equals("The Thing"))out.println("Here's the Thing");
			else if(s.equals("Human Torch"))out.println("It's Clobberin' Time.");
			else out.println("Not Now, I'm Working Over Here.");
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Thing().run();
	}
}
