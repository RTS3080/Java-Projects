import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Reeds {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("reeds.dat"));
		int times = file.nextInt();
		ArrayList<Reed> a = new ArrayList<Reed>();
		file.nextLine();
		while(times-- > 0) {
			Reed r = new Reed(file.nextInt(), file.nextBoolean(), file.nextInt(),
					file.nextInt(), file.nextInt(), file.nextBoolean(), file.nextInt());
			file.nextLine();
			a.add(r);
		}
		Collections.sort(a);
		System.out.println(a.toString().replaceAll("[\\[\\],]+",""));
	}
	
	public static void main(String[]args)throws Exception{
		new Reeds().run();
	}
}
class Reed implements Comparable<Reed>{
	
	int id, phds, height, kids, members;
	boolean married, stretch;
	
	public Reed(int i, boolean m, int p, int h, int k, boolean s, int e) {
		id = i;
		married = m;
		phds = p;
		height = h;
		kids = k;
		stretch = s;
		members = e;
	}
	
	public int compareTo(Reed r) {
		if(r.married != married)return married? -1: 1;
		if(r.kids != kids)return kc(kids, r.kids);
		if(r.members != members)return mc(members, r.members);
		if(r.stretch != stretch)return stretch? -1: 1;
		if(r.phds != phds)return phds - r.phds;
		return r.height - height;
	}
	
	private int kc(int k1, int k2) {
		if(k1 == 2)return -1;
		if(k2 == 2)return 1;
		return k2 - k1;
	}
	
	private int mc(int m1, int m2) {
		if(m1 == 4)return -1;
		if(m2 == 4)return 1;
		if(m1 == 5)return -1;
		if(m2 == 5)return 1;
		return m1 - m2;
	}
	
	public String toString() {
		return "" + id;
	}
}