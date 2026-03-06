import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Day {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("day.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String name = file.nextLine().trim()+"!";
			int len = Math.max(name.length(), 7) + 2;
			for(int y = 0; y < len; y++)
				System.out.print("-");
			System.out.println();
			String w = "Welcome";
			while(w.length() < len - 2) {
				w += " ";
				if(w.length() < len - 2)
					w = " " + w;
			}
			System.out.println("|" + w + "|");
			while(name.length() < len - 2) {
				name += " ";
				if(name.length() < len - 2)
					name = " " + name;
			}
			System.out.println("|" + name + "|");
			String st = "***";
			while(st.length() < len - 6) {
				st += "*";
				if(st.length() < len - 6)
					st = "*" + st;
			}
			System.out.println("|  " + st + "  |");
			for(int y = 0; y < len; y++)
				System.out.print("-");
			System.out.println();
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Day().run();
	}
}
