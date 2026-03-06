package Solutions;

import java.util.*;
import java.io.*;
import java.math.*;

// if we think about this we can realize that the direction of the diagonal in which we sum the number doesn't matter so we just have to sum each diagonal
public class louetta {
    public static void main(String[] args) throws Exception {
        new louetta().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("louetta.dat"));
        // Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            int[][] m = new int[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            String ans = "";
            for(int sc = col-1; sc >= 0;sc--){
                int r = 0, c = sc;
                long sum = 0;
                while(r < row && c < col){
                    sum+=m[r][c];
                    r++;
                    c++;
                }
                ans+=sum+" ";
            }
            for(int sr = 1;sr < row;sr++){
                int r = sr,c = 0;
                long sum = 0;
                while(r < row && c< col){
                    sum+=m[r][c];
                    r++;
                    c++;
                }
                ans+=sum+" ";
            }
            System.out.println(ans.trim() + "\n" + "-".repeat(10));
        }
        f.close();
    }
}