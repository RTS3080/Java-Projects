package Solutions;

import java.util.*;
import java.io.*;

public class queen {
    HashSet<String> hs;
    char[][] m;
    public static void main(String[] args) throws Exception {
        new queen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("queen.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int N = f.nextInt();
            m = new char[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(m[i], '.');
            }
            hs =new HashSet<>();
            recur(0,N,new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
            System.out.println(hs.size());
        }
        f.close();
    }
    public void recur(int r, int queen, Set<Integer> row, Set<Integer> col, Set<Integer> pd, Set<Integer> nd){
        if(queen == 0){
            String ln = "";
            for (int i = 0; i < m.length; i++) {
                ln+=new String(m[i]);
            }
            hs.add(ln);
            return;
        }
        row.add(r);
        for(int c = 0; c< m[r].length;c++){
            if(!col.contains(c) && !pd.contains(r + c) && !nd.contains(r-c)){
                col.add(c);
                pd.add(r+c);
                nd.add(r-c);
                m[r][c] = 'Q';
                recur(r+1, queen-1, row, col, pd, nd);
                col.remove(c);
                pd.remove(r+c);
                nd.remove(r-c);
                m[r][c] = '.';
            }
        }
        row.remove(r);
    }
}