import java.io.*;
import java.util.*;
import java.math.*;
public class hardest {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("hardest.dat"));
		while(file.hasNext()) {
			String s = file.nextLine();
			if (s.equals("END")) {
				continue;
			}
			if (s.equals("ENDOFINPUT")) {
				break;
			}
			if (s.equals("START")) {
				//reset vars
				continue;
			}
			char[] ca = s.toCharArray();
			char[] ra = new char[ca.length];
			for (int i = 0; i < ca.length; i++) {
				ra[i] = ca[i];
				if (Character.isAlphabetic(ca[i])) {
					int r = ((ca[i]-5));
					if (r < 65) r = (26)+r;
					ra[i] = (char)r;
				}
			}
			System.out.println(ra);
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new hardest().run();
	}
}
