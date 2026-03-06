package Solutions;

import java.util.*;
import java.io.*;
import java.math.*;

public class penelope {
    public static void main(String[] args) throws Exception {
        new penelope().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("penelope.dat"));
        // Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] treasure = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long[] heaters = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(treasure);
            Arrays.sort(heaters);
            long l = 0, r = (long)1e9;
            while(l < r){
                long radius = (l + r) >> 1;
                int j = 0;
                for(int i = 0;i < heaters.length;i++){
                    while(j < treasure.length && Math.abs(treasure[j] - heaters[i]) <= radius){
                        j++;
                    }
                }
                if(j == treasure.length){
                    r = radius;
                }
                else l = radius+1;
            }
            System.out.println(r);
        }
        f.close();
    }
}