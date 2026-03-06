import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Clearance {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("clearance.dat"));
		int times = file.nextInt();
		int[] pow = new int[5], sec = new int[5];
		char[] clear = "OSABP".toCharArray();
		file.nextLine();
		while(times-- > 0) {
			String s = file.next().trim();
			int power = file.nextInt(), sec_cle = sc(s);
			file.nextLine();
			System.out.printf("%s %d%02d%c%02d%n",s,power,(++pow[power - 1]),clear[sec_cle],(++sec[sec_cle]));
			//System.out.println(s+" "+power+(++pow[power - 1])+clear[sec_cle]+(++sec[sec_cle]));
		}
	}
	
	int sc (String s) {
		switch(s) {
		case "Batman": case "Superman": case "Wonder-Woman": case "Flash": case "Green-Lantern":
			return 0;
		case "Martian-Manhunter": case "Aquaman": case "Hawkgirl": case "Hawkman": case "Cyborg":
			case "Green-Arrow": case "Black-Canary": return 1;
		case "Firestorm": case "Red-Tornado": case "Black-Lightning": case "Mr-Terrific": 
			case "Wildcat": case "Hourman": case "Atom": return 2;
		case "Atom-Smasher": case "Question": case "Metamorpho": case "Huntress": case "Dr-Fate":
			case "Steel": case "Plastic-Man": case "Icon": return 3;
		case "Supergirl": case "Booster-Gold": case "You": return 4;
		}
		return -1;
	}
	
	public static void main(String[]args)throws Exception{
		new Clearance().run();
	}
}
