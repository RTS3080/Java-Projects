import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class waddleWays{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("waddleWays".toLowerCase()+".in"));

        rows = f.nextInt();
        cols = f.nextInt();
        int K = f.nextInt();
        f.nextLine();

        numD = 0;

        grid = new char[rows][cols];
        for (int r = 0; r < rows; r++){
            grid[r] = f.nextLine().toCharArray();
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 'D') numD++;
            }
        }

        dp = new long[numD+1][rows][cols];
        for (int d = 0; d < dp.length; d++){
            for (int r = 0; r < dp[d].length; r++){
                for (int c = 0; c < dp[d][r].length; c++){
                    dp[d][r][c] = -1;
                }
            }
        }

        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 'D') dp[1][0][c] = 1;
            else dp[0][0][c] = 1;
        }

        for (int c = 0; c < cols; c++) {
            recur(rows-1, c);
        }

        for (int d = 0; d < numD; d++){
            for (int r = 0; r < rows; r++){
                System.out.println(Arrays.toString(dp[d][r]));
            }
            System.out.println("-".repeat(10));
        }

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == '#') continue;

                boolean hasD = grid[r][c] == 'D';
                if (c-1 >= 0 && grid[r][c-1] != '#'){
                    for (int d = 0; d < numD; d++){
                        dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r][c-1];
                    }
                }
                if (c+1 < cols && grid[r][c+1] != '#'){
                    for (int d = 0; d < numD; d++){
                        dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r][c+1];
                    }
                }
                if (r-1 >= 0 && grid[r-1][c] != '#'){
                    for (int d = 0; d < numD; d++){
                        dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r-1][c];
                    }
                }
            }
        }

        for (int d = 0; d < numD; d++){
            for (int r = 0; r < rows; r++){
                System.out.println(Arrays.toString(dp[d][r]));
            }
            System.out.println("-".repeat(10));
        }

        f.close();
    }

    int numD;
    int rows;
    int cols;

    char[][] grid;
    long[][][] dp;

    public void recur(int r, int c){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) return;
        if (grid[r][c] == '#') return;

        boolean filled = false;
        for (int i = 0; i < dp.length; i++) if (dp[i][r][c] != -1) filled = true;
        if (filled) return;

        dp[0][r][c] = Integer.MIN_VALUE;

        recur(r-1, c);
        recur(r, c-1);
        recur(r, c+1);

        boolean hasD = grid[r][c] == 'D';

        if (c-1 >= 0 && grid[r][c-1] != '#'){
            for (int d = 0; d < numD; d++){
                dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r][c-1];
            }
        }
        if (c+1 < cols && grid[r][c+1] != '#'){
            for (int d = 0; d < numD; d++){
                dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r][c+1];
            }
        }
        if (r-1 >= 0 && grid[r-1][c] != '#'){
            for (int d = 0; d < numD; d++){
                dp[d+(hasD ? 1 : 0)][r][c] += dp[d][r-1][c];
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new waddleWays().run();
    }
}
