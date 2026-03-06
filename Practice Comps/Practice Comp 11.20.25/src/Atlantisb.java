import java.io.*;
import java.lang.*;
import java.util.*;

public class Atlantisb {
	
	int[][][] smat;
	char[][][] mat;
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("atlantis.dat"));
		int times = file.nextInt(), i = 1;
		file.nextLine();
		while(times-- > 0) {
			int d = file.nextInt(), r = file.nextInt(), c = file.nextInt(), t = file.nextInt();
			int sr = -1, sc = -1, sd = -1;
			file.nextLine();
			smat = new int[d][r][c];
			mat = new char[d][r][c];
			for(int dd = 0; dd < d; dd++) 
				for(int rr = 0; rr < r; rr++) {
					mat[dd][rr] = file.nextLine().trim().toCharArray();
					Arrays.fill(smat[dd][rr], Integer.MAX_VALUE);
					for(int cc = 0; cc < c; cc++)
						if(mat[dd][rr][cc] == 'S') {
							sr = rr;
							sd = dd;
							sc = cc;
						}
				}
			System.out.println("Test Case #" + (i++) + ":");
			solve(sd, sr, sc, 0);
			while(t-- > 0) {
				int ed = file.nextInt(), er = file.nextInt(), ec = file.nextInt();
				file.nextLine();
				System.out.println(smat[ed][er][ec] == Integer.MAX_VALUE? "Swept away by the Riptide.": smat[ed][er][ec]);
			}
		}
	}
	
	public void solve(int d, int r, int c, int s) {
		if(r < 0 || d < 0 || c < 0 || d >= mat.length || r >= mat[d].length || 
				c >= mat[d][r].length || mat[d][r][c] == '#' || smat[d][r][c] <= s)return;
		smat[d][r][c] = s++;
		if(mat[d][r][c] == '@') s+= 2;
		if(mat[d][r][c] == 'D') solve(d + 1, r, c, s);
		else if(mat[d][r][c] == 'U') solve(d - 1, r, c, s);
		else if(mat[d][r][c] == 'R') solve(d, r, c + 1, s);
		else if(mat[d][r][c] == 'L') solve(d, r, c - 1, s);
		else if(mat[d][r][c] == 'F') solve(d, r + 1, c, s);
		else if(mat[d][r][c] == 'B') solve(d, r - 1, c, s);
		else {
			solve(d + 1, r, c, s);
			solve(d - 1, r, c, s);
			solve(d, r + 1, c, s);
			solve(d, r - 1, c, s);
			solve(d, r, c + 1, s);
			solve(d, r, c - 1, s);
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Atlantisb().run();
	}
}
