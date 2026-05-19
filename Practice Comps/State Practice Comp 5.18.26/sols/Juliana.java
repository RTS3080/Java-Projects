/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.*;
import java.util.*;

public class Juliana {
	public static void main(String[]args)throws Exception{
		new Juliana().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("juliana.dat"));
		int tcs = file.nextInt(), times = file.nextInt();
		file.nextLine();
		ArrayList<String> peeps = new ArrayList<String>();
		ArrayList<String[]>lines = new ArrayList<String[]>();
		TreeMap<String, Person> tm = new TreeMap<String, Person>();
		while(times-- > 0) {
			String b = file.nextLine().trim();
			String[] s = b.split(":");
			peeps.add(s[0].trim());
			String[] r = s[1].trim().split(" ");
			Person p = new Person(Integer.parseInt(r[0]),s[0],r[1],r[2]);
			tm.put(s[0], p);
			lines.add(r);
		}
		boolean[][] cons = new boolean[peeps.size()][peeps.size()];
		for(int i = 0; i < peeps.size(); i++) {
			String[] s = lines.get(i);
			for(int k = 3; k < s.length; k+=2) {
				String n = s[k]+" "+s[k + 1];
				cons[i][peeps.indexOf(n)] = true;
			}
		}
		while(tcs --> 0) {
			Queue<Integer> qu = new LinkedList<Integer>();
			TreeSet<String> na = new TreeSet<String>();
			boolean[] visit = new boolean[peeps.size()];
			String name = file.nextLine().trim();
			int y = file.nextInt();
			String fm = file.nextLine().trim();
			int start = peeps.indexOf(name);
			qu.add(start);
			while(!qu.isEmpty()) {
				int curr = qu.poll();
				visit[curr] = true;
				for(int i = 0; i < cons.length; i++)
					if(i != curr && cons[curr][i] && !visit[i])
						qu.add(i);
			}
			for(int i = 0; i < visit.length; i++) {
				Person p = tm.get(peeps.get(i));
				if(visit[i] && (p.major.equals(fm) || p.field.equals(fm)) && p.yoe >= y && i != start)
					na.add(peeps.get(i));
			}
			String fin = "";
			for(String s:na)
				fin += ", " + s;
			System.out.println(fin.length() == 0? "": fin.substring(2));
		}
		file.close();
	}
}
class Person{
	int yoe;
	String name, field, major;
	public Person(int y, String n, String m, String f) {
		yoe = y;
		name = n;
		field = f;
		major = m;
	}
}