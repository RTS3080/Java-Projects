import java.util.*;
import java.io.*;
import java.awt.*;

public class treasure{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("treasure".toLowerCase()+".in"));

        int numInst = f.nextInt();
        int numTreasures = f.nextInt();

        long x = 0;
        long y = 0;

        String[] dirs = new String[numInst];
        long[] len = new long[numInst];

        for (int i = 0; i < numInst; i++) {
            dirs[i] = f.next();
            len[i] = f.nextLong();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int[][] queries = new int[numTreasures][2];
        for (int i = 0; i < numTreasures; i++) {
            queries[i][0] = f.nextInt();
            queries[i][1] = i;
        }
        Arrays.sort(queries, (a, b) -> {
            return a[0] - b[0];
        });

        long[][] ans = new long[numTreasures][2];

        for (int i = 0; i < numInst; i++){
            switch (dirs[i]){
                case "W":
                    x -= len[i];
                    break;
                case "E":
                    x += len[i];
                    break;
                case "N":
                    y += len[i];
                    break;
                case "S":
                    y -= len[i];
                    break;
            }

            if (Arrays.binarySearch(queries, i+1) >= 0){
                ans[Arrays.binarySearch(queries, i+1)] = new long[]{x, y};
            }
        }

        for (long[] each:ans){
            System.out.println(each[0] + " " + each[1]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new treasure().run();
    }
}
