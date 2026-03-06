import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.temporal.*;
public class Legion {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("legion.dat"));
		int villains = file.nextInt(), times = file.nextInt();
		file.nextLine();
		TreeMap<String,ArrayList<Villain>> tm = new TreeMap<String,ArrayList<Villain>>();
		while(villains-- > 0) {
			Villain v = new Villain(file.next(), days(file.next(),"12-25-2025"), file.nextBoolean());
			//if(v.name.equals("Cheetah"))System.out.println(v.dil);
			String[] s = file.nextLine().trim().split(" ");
			for(String r:s) {
				if(!tm.containsKey(r))
					tm.put(r, new ArrayList<Villain>());
				tm.get(r).add(v);
			}
		}
		while(times-- > 0) {
			TreeSet<Villain> ts = new TreeSet<Villain>();
			String[] s = file.nextLine().trim().split(" ");
			for(String t:s)
				for(Villain v:tm.get(t))
					ts.add(v);
			System.out.println(ts.toString().replaceAll("[\\[\\],]+",""));
		}
	}
	
	long days(String start_date,
                   String end_date)throws Exception{
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "MM-dd-yyyy");
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
            long difference_In_Time
                = d2.getTime() - d1.getTime();
            long difference_In_Days
                = (difference_In_Time
                   / (1000 * 60 * 60 * 24));
            return difference_In_Days;
	 }
	
	public static void main(String[]args)throws Exception{
		new Legion().run();
	}
}
class Villain implements Comparable<Villain>{
	
	String name;
	long dil;
	boolean found;
	
	public Villain(String n, long d, boolean f) {
		name = n;
		dil = d;
		found = f;
	}
	
	public int compareTo(Villain v) {
		if(found && !v.found) return -1;
		if(!found && v.found) return 1;
		if(dil != v.dil) {Long.compare(v.dil, dil);
			//out.println(v.name+" "+name + " "+Long.compare(v.dil, dil));
			return Long.compare(v.dil, dil);
		}
		return name.compareTo(v.name);
	}
	
	public String toString() {
		return name;
	}
}