import java.io.*;
import java.util.*;
import java.math.*;
public class blue {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("blue.dat"));
		while(file.hasNextLine()) {
			file.nextLine();
			char[] c = file.nextLine().toCharArray();
			recur(c,0);
			System.out.println(c);
			file.nextLine();
		}
	}
	public int recur(char[] c, int in) {
		if(in >= c.length || c[in] == '0') return 0;
		if(Character.isAlphabetic(c[in])) {
			int i = recur(c,in+1);
			c[in] = (char) ('0' + (i%10));
			return i + 1;
		}
		assert Character.isDigit(c[in]);
		c[in]--;
		if(in + c[in] - 47 >= c.length) return recur(c, in+1) + 1;
		return recur(c, in + c[in] - 47) + 1;
	}
	
	public static void main(String[] arg) throws Exception
	{
		new blue().run();
	}
}
