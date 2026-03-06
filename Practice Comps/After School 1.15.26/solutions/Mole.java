import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Mole {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("mole.dat"));
		int times = file.nextInt(), num = 0;
		file.nextLine();
		int hmax = -1, hmin = 1000, havg = 0;
		int wmax = -1, wmin = 1000, wavg = 0;
		int lmax = -1, lmin = 1000, lavg = 0;
		while(times-- > 0) {
			file.next();
			int h = file.nextInt();
			int w = file.nextInt();
			int l = file.nextInt();
			file.nextLine();
			hmax = Math.max(hmax, h);
			wmax = Math.max(wmax, w);
			lmax = Math.max(lmax, l);
			hmin = Math.min(hmin, h);
			wmin = Math.min(wmin, w);
			lmin = Math.min(lmin, l);
			havg += h;
			wavg += w;
			lavg += l;
			num++;
		}
		havg /= num;
		wavg /= num;
		lavg /= num;
		System.out.println("--------------------");
		System.out.println("|      |MIN|MAX|AVG|");
		System.out.println("|HEIGHT|"+hmin+"|"+hmax+"|"+havg+"|");
		System.out.println("|WEIGHT|"+wmin+"|"+wmax+"|"+wavg+"|");
		System.out.println("|LIFTED|"+lmin+"|"+lmax+"|"+lavg+"|");
		System.out.println("--------------------");
	}
	
	public static void main(String[]args)throws Exception{
		new Mole().run();
	}
}
