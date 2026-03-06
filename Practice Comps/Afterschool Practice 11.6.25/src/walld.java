import java.util.*;
import java.io.*;
import java.awt.*;

public class walld{

    int[] rMove = {-1, 0, 0, 1};
    int[] cMove = {0, -1, 1, 0};

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("walld".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();
            int K = f.nextInt();

            int[][] mat = new int[N][N];
            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    mat[r][c] = f.nextInt();
                }
            }

            int[][][] min = new int[K+1][N][N];
            for (int i = 0; i < K+1; i++){
                for (int[] each:min[i]) Arrays.fill(each, Integer.MAX_VALUE);
            }

            Queue<Integer> q = new LinkedList<>();

            q.offer(N/2); q.offer(N/2); q.offer(mat[N/2][N/2]); q.offer(0);

            while (!q.isEmpty()){
                int r = q.poll();
                int c = q.poll();
                int num = q.poll();
                int path = q.poll();

                if (num > K) continue;
                min[num][r][c] = path;

                for (int i = 0; i < 4; i++){
                    int tempR = r + rMove[i];
                    int tempC = c + cMove[i];

                    if (outOfBounds(tempR, tempC, N, N)) continue;
                    if (min[num][tempR][tempC] <= path+1) continue;
                    min[num][tempR][tempC] = path+1;

                    q.offer(tempR); q.offer(tempC); q.offer(num+mat[tempR][tempC]); q.offer(path+1);
                }
            }

            int result = Integer.MAX_VALUE;

            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    result = Math.min(result, min[K][r][c]);
                }
            }

            System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
        }

        f.close();
    }

    public boolean outOfBounds(int r, int c, int row, int col){
        return r < 0 || r >= row || c < 0 || c >= col;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new walld().run();
    }
}
