package Solutions;

import java.util.*;
import java.io.*;
import java.math.*;

public class nramchi {
    public static void main(String[] args) throws Exception {
        new nramchi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("nramchi.dat"));
        // Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt();
            long d = f.nextLong();
            List<Object[]> road = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                road.add(new Object[]{f.nextInt(),f.nextInt(),f.nextLong()});
            }
            long[][] shadow = new long[n][n];
            int cnt = 0;
            for(int mask = 0;mask < 1 << n;mask ++){
                for (int i = 0; i < n; i++) {
                    Arrays.fill(shadow[i], Long.MAX_VALUE);
                }
                for (Object[] r : road){
                    int u = (int)r[0], v = (int)r[1];
                    long w = (long)r[2];
                    if(((mask & 1 << u) ==0) || ((mask & 1 << v) == 0)) continue;
                    shadow[u][v] = Math.min(shadow[u][v], w);
                    shadow[v][u] = Math.min(shadow[v][u], w);
                }
                for (int k = 0; k < n; k++) {
                    if((mask & 1 << k) == 0) continue;
                    for (int i = 0; i < n; i++) {
                        if((mask & 1 << i) == 0) continue;
                        for (int j = 0; j < n; j++) {
                            if((mask & 1 << j) == 0) continue;
                            if(shadow[i][k] != Long.MAX_VALUE && shadow[k][j] != Long.MAX_VALUE){
                                shadow[i][j] = Math.min(shadow[i][j], shadow[i][k] + shadow[k][j]);
                            }
                        }
                    }
                }
                long mx = 0;
                for (int i = 0; i < n; i++) {
                    if((mask & 1 << i) ==0) continue;
                    for (int j = i+1; j < n; j++) {
                        if((mask & 1 << j) == 0) continue;
                        mx = Math.max(mx, shadow[i][j]);
                    }
                }
                if(mx <= d) cnt++;
            }
            System.out.println(cnt);
        }
        f.close();
    }
}