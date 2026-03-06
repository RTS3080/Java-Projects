import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Crime {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("crime.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			System.out.println(get(file.nextLine().trim()));
		}
	}
	
	public String get(String c) {
		switch(c) {
		case "Ultraman":		return "Wonder Woman";
		case "Owlman":			return "Batman";
		case "Superwoman":		return "Martian Manhunter";
		case "Johnny Quick":	return "Flash";
		case "Power Ring":		return "Green Lantern";
		case "Deathstorm":		return "Firestorm";
		case "Archer":			return "Green Arrow";
		case "J'edd J'arkus":	return "Cyborg";
		case "Grid":			return "Superman";
		case "Sea King":		return "Aquaman";
		case "Atomica":			return "Atom";
		}
		return "APPLEBOTTOM JEANS";
	}
	
	public static void main(String[]args)throws Exception{
		new Crime().run();
	}
}
