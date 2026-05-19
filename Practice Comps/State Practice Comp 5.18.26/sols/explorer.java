import java.io.*;
import java.util.*;
import java.math.*;
public class explorer {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("explorer.dat"));
		while(file.hasNext()) {
			String s = file.nextLine();
			if (s.equals("END")) {
				continue;
			}
			if (s.equals("START")) {
				continue;
			}
			String[] sa = s.split(" ");
			double r = Double.parseDouble(sa[0]);
			double gas = Double.parseDouble(sa[1]);
			double angle = Double.parseDouble(sa[2]);
			if (angle > 180) angle = 360 - angle;
			double cir = 2*3.14159*r;
			double arc = (angle/360)*cir*2;
			double pd = 5*gas;
			if (pd >= arc) {
				double rr = (pd-arc)/5;
				System.out.println("YES " + (int)(rr));
			}
			else {
				System.out.println("NO " + (int)pd);
			}
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new explorer().run();
	}
}
