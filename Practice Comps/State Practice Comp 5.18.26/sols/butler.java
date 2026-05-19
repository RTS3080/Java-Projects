import java.io.*;
import java.util.*;
import java.math.*;
public class butler {
	int[][] graph;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("butler.dat"));
		String s = file.nextLine();
		while(s.length()>0&&s.charAt(0)=='S')
		{
			Scanner scan = new Scanner(s);
			scan.next();
			int a = scan.nextInt();
			int n = scan.nextInt();
			graph = new int[n][n];
			int door = 0;
			for(int i = 0; i < n; i++)
			{
				s = file.nextLine();
				if(s.length()>0)
				{
					scan = new Scanner(s);
					while(scan.hasNextInt())
					{
						int j = scan.nextInt();
						door++;
						graph[i][j]++;
						graph[j][i]++;
					}
				}
			}
			file.nextLine();
			if(file.hasNext())
				s = file.nextLine();
			else
				s = "";
			boolean good = solve(a);
			if(good)
				System.out.printf("YES %d%n", door);
			else
				System.out.println("NO");
		}
	}
	public boolean solve(int i)
	{
		if(i==0)
		{
			boolean a = true;
			for(int r = 0; r < graph.length; r++)
				for(int c = 0; c < graph.length; c++)
					if(graph[r][c]>0)
						a = false;
			if(a) return true;
		}
		boolean good = false;
		for(int j = 0; j < graph.length; j++)
			if(graph[i][j]>0)
			{
				int t = graph[i][j];
				graph[i][j]--;
				graph[j][i]--;
				good = good||solve(j);
				graph[i][j] = t;
				graph[j][i] = t;
			}
		return good;
	}
	
	public static void main(String[] arg) throws Exception
	{
		new butler().run();
	}
}
