import java.awt.Point;
import java.io.*;
import java.util.*;
import java.math.*;
public class nemo {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("nemo.dat"));
		while(file.hasNext()) {
			String[] sa = file.nextLine().split(" ");
			int l = Integer.parseInt(sa[1]);
			int w = Integer.parseInt(sa[2]);
			int d = Integer.parseInt(sa[3]);
			String[] dl = file.nextLine().split(" ");
			String[] fl = file.nextLine().split(" ");
			file.nextLine();
			List<Thing> dlist = new ArrayList<>();
			List<Thing> flist = new ArrayList<>();
			for (String s : dl) {
				Thing t = new Thing(s,d);
				dlist.add(t);
			}
			for (String s : fl) {
				Thing f = new Thing(s,d);
				flist.add(f);
			}
			int n = 0;
			for (Thing dd : dlist) {
				for (int i = flist.size()-1; i >= 0; i--) {
					if (flist.get(i).close(dd)) {
						flist.remove(i);
						n++;
					}
				}
			}
			if (n == 0) {
				System.out.println("None of dem fish blowed up!");
			}
			else System.out.println("AIEE, I got " + n + " fish, me!");
		}
	}
	
	class Thing {
		int x;
		int y;
		int z;
		public Thing(String s, int d) {
			String[] sa = s.split(",");
			x = Integer.parseInt(sa[0]);
			y = Integer.parseInt(sa[1]);
			z = Integer.parseInt(sa[2]);
			if (z > d) z = d;
		}
		public boolean close(Thing o) {
			return (Math.sqrt(Math.pow(x-o.x, 2)+Math.pow(y-o.y, 2)+Math.pow(z-o.z, 2)) <= 1);
		}
	}
	
	public static void main(String[] arg) throws Exception
	{
		new nemo().run();
	}
}
