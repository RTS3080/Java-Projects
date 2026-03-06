import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class TeamUp {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("teamup.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int ss = file.nextInt();
			int sf = file.nextInt();
			int sg = file.nextInt();
			int hs = file.nextInt();
			int hf = file.nextInt();
			int hg = file.nextInt();
			int x = file.nextInt();
			int y = file.nextInt();
			int v = file.nextInt();
			file.nextLine();
			double spidey = 0, torch = 0;
			while(v-- > 0) {
				file.next();
				int vx = file.nextInt();
				int vy = file.nextInt();
				int vd = file.nextInt();
				file.nextLine();
				spidey += dist(x, vx, y, vy) / ss;
				spidey += vd * sf + sg;
				torch += dist(x, vx, y, vy) / hs;
				torch += vd * hf + hg;
				x = vx;
				y = vy;
			}
			//System.out.println(spidey + " " + torch);
			System.out.println(spidey - torch <= 0? "He's A Menace!!": "Get Torched.");
		}
	}
	
	double dist(double x1, double x2, double y1, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public static void main(String[]args)throws Exception{
		new TeamUp().run();
	}
}
