package Solutions;

import java.util.*;
import java.io.*;
import java.math.*;

public class barisa {
    public static void main(String[] args) throws Exception {
        new barisa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("barisa.dat"));
        // Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {

            String[] ln = f.nextLine().trim().split(",");
            List<int[]> al = new ArrayList<>();
            for (String each : ln) {
                String[] data = each.split("\\s+");
                al.add(new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])});
            }
            Collections.sort(al, (a, b) -> a[1] - b[1] == 0 ? a[2] - b[2] : a[1] - b[1]);
            int n = al.size();
            long[] dp = new long[n];
            dp[0] = al.get(0)[2];
            for (int i = 1; i < n; i++) {
                int index = search(al, i, al.get(i)[0]);
                long p = al.get(i)[2];
                if (index != -1) p += dp[index];
                dp[i] = Math.max(p, dp[i - 1]);
            }
            System.out.println(dp[n - 1]);
        }
        f.close();
    }
    public int search(List<int[]>al, int right, int start){
        int l = 0, r = right-1;
        while(l <= r){
            int m = (l + r) >> 1;
            if(al.get(m)[1] <= start){
                if(m + 1 <= al.size()-1 && al.get(m+1)[1] <= start){
                    l = m + 1;
                }
                else return m;
            }
            else r = m-1;
        }
        return -1;
    }
}