import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Bridge {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("bridge.dat"));
		int n = file.nextInt(), m = file.nextInt();
		file.nextLine();
		ArrayList<Entry> db = new ArrayList<Entry>();
		TreeMap<Integer, Integer> u = new TreeMap<Integer,Integer>();
		while(n-- > 0) {
			Entry e = new Entry(file.nextInt(), file.nextInt(), file.nextInt(), 
					file.nextInt(), file.nextBoolean(), file.nextBoolean(), file.nextBoolean());
			file.nextLine();
			db.add(e);
			u.put(e.winner, u.getOrDefault(e.winner, 0) + 1);
		}
		int max = -1;
		String res = "";
		//System.out.println(u);
		for(int i:u.keySet()) {
			if(i != -1 && u.get(i) > max) {
				max = u.get(i);
				res = i + " ";
			}
			else if(i != -1 && u.get(i) == max) {
				max = u.get(i);
				res += i + " ";
			}
		}
		while(m-- > 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(Entry e:db)
				a.add(e.num);
			String q = file.next();
			file.next();
			String[] c = file.nextLine().trim().split(", ");
			for(String t:c) {
				String[] r = t.split("=");
				for(Entry e:db)
					if(!e.match(r[0], r[1]))
						a.remove((Integer)e.num);
			}
			Collections.sort(a);
			if(a.isEmpty()) {
				System.out.println("Doom is upon us.");
				continue;
			}
			if(q.equals("SELECT"))
				System.out.println(a.toString().replaceAll("[\\[\\],]+",""));
			else
				System.out.println(a.size());
		}
		out.println(res.trim());
	}
	
	public static void main(String[]args)throws Exception{
		new Bridge().run();
	}
}
class Entry{
	
	int num, u1, u2, winner;
	boolean supes, swans, maps;
	
	public Entry(int a, int b, int c, int d, boolean e, boolean f, boolean g) {
		num = a;
		u1 = b;
		u2 = c;
		winner = d;
		supes = e;
		swans = f;
		maps = g;
	}
	
	public boolean match(String field, String val) {
		switch(field) {
		case "WINNER":return winner == Integer.parseInt(val);
		case "SWANS":return swans == Boolean.parseBoolean(val);
		case "MAPMAKERS":return maps == Boolean.parseBoolean(val);
		case "SUPERHEROES":return supes == Boolean.parseBoolean(val);
		}
		return false;
	}
}