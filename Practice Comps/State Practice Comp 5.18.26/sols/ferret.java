import java.io.*;
import java.util.*;
import java.math.*;
public class ferret {
	char[][] map;
	ArrayList<Guard> guards;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("ferret.dat"));
		String s = file.nextLine();
		while(s.length()>0&&s.charAt(0)=='S')
		{
			Scanner scan = new Scanner(s); scan.next();
			int cs = scan.nextInt();
			int rs = scan.nextInt();
			int lr = 0, lc = 0;
			guards = new ArrayList<>();
			map = new char[rs][cs];
			for(int i = 0; i < map.length; i++)
				map[i] = file.nextLine().toCharArray();
			for(int r = 0; r < rs; r++)
				for(int c = 0; c < cs; c++)
				{
					if(map[r][c]=='L')
					{
						lr = r; lc = c;
					}
					if(map[r][c]=='S')
						guards.add(new Guard(r,c));
				}
			boolean good = recur(lr,lc,0);
			file.nextLine();
			if(file.hasNextLine())
				s = file.nextLine();
			else
				s = "";
			System.out.println(good?"FERRET":"GARRET");
		}
	}
	public boolean recur(int r, int c, int t)
	{
		if(t!=0)
		{
			for(Guard g : guards)
				if(g.coll(r, c, t-1))
					return false;
		}
		if(r<0||c<0||r>=map.length||c>=map[0].length)
			return false;
		for(Guard g : guards)
			if(g.coll(r, c, t))
				return false;
		if(map[r][c]=='P')
			return false;
		if(map[r][c]=='G')
			return true;
		return recur(r+1,c,t+1)||recur(r+1,c+1,t+1)||recur(r+1,c-1,t+1);
	}
	
	
	public class Guard
	{
		int r, c;
		public Guard(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		boolean coll(int or, int oc, int t)
		{
			if(t%4==0)
				return (oc==c&&or<=r);
			if(t%4==1)
				return (oc>=c&&or==r);
			if(t%4==2)
				return (oc==c&&or>=r);
			if(t%4==3)
				return (oc<=c&&or==r);
			return false;
		}
	}
	
	
	public static void main(String[] arg) throws Exception
	{
		new ferret().run();
	}
}
