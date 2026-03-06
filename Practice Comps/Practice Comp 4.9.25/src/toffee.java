import java.util.*;
import java.io.*;

public class toffee{

    int[][] dp;
    int[][] grid;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("toffee".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();
            grid = new int[N][N];
            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    grid[r][c] = f.nextInt();
                }
            }

            dp = new int[N][N];
            int result = 0;

            for (int c = 0; c < N; c++){
                result = Math.max(result, search(0, c));
            }

            System.out.println(result);
        }
        f.close();
    }

    public int search(int row, int col){
        if (row == grid.length || col == grid[0].length) return 0;
        if (dp[row][col]  != 0) return dp[row][col];
        return dp[row][col] = Math.max(search(row+1, col), search(row+1, col+1))+grid[row][col];
    }



    public static void main(String[] args) throws FileNotFoundException{
        new toffee().run();
    }
}
