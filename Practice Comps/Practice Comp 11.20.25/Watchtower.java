import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Watchtower {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("watchtower.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			double[] speed = new double[3], earth = new double[3], tower = new double[3];
			String[] s = file.next().trim().replaceAll("[\\(\\)]+","").split(",");
			String[] e = file.next().trim().replaceAll("[\\(\\)]+","").split(",");
			String[] o = file.next().trim().replaceAll("[\\(\\)]+","").split(",");
			int t = file.nextInt();
			file.nextLine();
			speed[0] = Double.parseDouble(s[0]);
			speed[1] = Double.parseDouble(s[1]);
			speed[2] = Double.parseDouble(s[2]);
			earth[0] = Double.parseDouble(e[0]);
			earth[1] = Double.parseDouble(e[1]);
			earth[2] = Double.parseDouble(e[2]);
			tower[0] = Double.parseDouble(o[0]);
			tower[1] = Double.parseDouble(o[1]);
			tower[2] = Double.parseDouble(o[2]);
			double x = earth[0] - (tower[0] + speed[0] * t);
			double y = earth[1] - (tower[1] + speed[1] * t);
			double z = earth[2] - (tower[2] + speed[2] * t);
			double dist = Math.sqrt(x * x + y * y + z * z);
			System.out.printf("%.3f%n",dist);
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Watchtower().run();
	}
}
