import java.io.*;
import java.util.*;
import java.math.*;
public class time {
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("time.dat"));
		while(file.hasNextLine()) {
			file.nextLine();
			int time = Integer.parseInt(file.nextLine());
			file.nextLine();
			boolean pm = time >= 12*60*60;
			int hour = time % (12*60*60) / 60 / 60;
			if(hour == 0) hour = 12;
			int min = time % 3600 / 60;
			int sec = time % 60;
			System.out.printf("%02d:%02d:%02d %s%n",hour,min,sec,pm ? "pm" : "am");
			
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new time().run();
	}
}
