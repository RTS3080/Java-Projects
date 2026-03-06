import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Incursion {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("incursion.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			double raft = file.nextDouble();
			int home = file.nextInt();
			Earth one = new Earth(file.nextDouble(), file.nextDouble(), 
					file.nextDouble(), file.nextDouble(), file.nextDouble());
			Earth two = new Earth(file.nextDouble(), file.nextDouble(), 
					file.nextDouble(), file.nextDouble(), file.nextDouble());
			Earth three = new Earth(file.nextDouble(), file.nextDouble(), 
					file.nextDouble(), file.nextDouble(), file.nextDouble());
			double i12 = collide(one, two);
			double i13 = collide(one, three);
			double i23 = collide(three, two);
			double time = 0;
			switch(home) {
				case 1:time = Math.min(i12, i13);break;
				case 2:time = Math.min(i23, i13);break;
				case 3:time = Math.min(i12, i23);break;
			}
			System.out.println((time < raft? "Out of time ": "Just in time ") + String.format("%.2f",time));
		}
	}
	
	public double collide(Earth a, Earth b) {
		if(a.speed != 0 && b.speed != 0)return Double.MAX_VALUE;
		double s = a.speed == 0? b.speed: a.speed;
		double d = dist(a, b);
		d -= a.r + b.r;
		if(d <= 0)return 0;
		return d / s;
	}
	
	public double dist(Earth a, Earth b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z));
	}
	
	public static void main(String[]args)throws Exception{
		new Incursion().run();
	}
}
class Earth{
	double x, y, z, r, speed;
	
	public Earth(double a, double b, double c, double d, double e) {
		x = a;
		y = b;
		z = c;
		r = d;
		speed = e;
	}
}