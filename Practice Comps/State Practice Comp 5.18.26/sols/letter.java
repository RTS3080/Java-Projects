import java.io.*;
import java.util.*;
import java.math.*;
public class letter {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("letter.dat"));
		while(file.hasNextLine()) {
			String line = file.nextLine();
			if(line.length() == 0) break;
			System.out.printf("%d : %d : %d : %d%n",
					line.replaceAll("[^A-Za-z]", "").length(),
					line.replaceAll("[^0-9]", "").length(),
					line.replaceAll("[A-Za-z0-9]", "").length(),
					line.length());
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new letter().run();
	}
}
