import java.util.*;
import java.io.*;
import java.awt.*;

public class volcano{

    int[] rMove = {-1, 0, 0, 1};
    int[] cMove = {0, -1, 1, 0};

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("volcano".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            f.nextLine();

            int vRow = 0, vCol = 0;
            int sRow = 0, sCol = 0;
            int eRow = 0, eCol = 0;


            char[][] maze = new char[rows][cols];
            for (int r = 0; r < rows; r++){
                String line = f.nextLine().trim();
                for (int c = 0; c < cols; c++){
                    maze[r][c] = line.charAt(c);

                    switch (maze[r][c]){
                        case 'S':
                            sRow = r;
                            sCol = c;
                            break;

                        case 'V':
                            vRow = r;
                            vCol = c;
                            break;

                        case 'C':
                            eRow = r;
                            eCol = c;
                            break;
                    }
                }
            }

            int[][] lavaSpread = new int[rows][cols];
            for (int[] each: lavaSpread){
                Arrays.fill(each, Integer.MAX_VALUE);
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(vRow); q.offer(vCol); q.offer(0);

            while (!q.isEmpty()){
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();

                if (outOfBounds(r, c, rows, cols)) continue;
                if (lavaSpread[r][c] <= t) continue;
                if (maze[r][c] == 'W') continue;

                lavaSpread[r][c] = t;

                for (int i = 0; i < 4; i++){
                    q.offer(r+rMove[i]); q.offer(c+cMove[i]); q.offer(t+1);
                }
            }

            int[][] minTime = new int[rows][cols];
            for (int[] each:minTime) Arrays.fill(each, Integer.MAX_VALUE);

            q.clear();

            q.offer(sRow); q.offer(sCol); q.offer(0);

            while (!q.isEmpty()){
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();

                if (outOfBounds(r, c, rows, cols)) continue;
                if (maze[r][c] == 'W' || maze[r][c] == 'T') continue;
                if (minTime[r][c] <= t) continue;
                if (lavaSpread[r][c] <= t) continue;

                minTime[r][c] = t;

                for (int i = 0; i < 4; i++){
                    q.offer(r+rMove[i]); q.offer(c+cMove[i]); q.offer(t+1);
                }
            }

            if (lavaSpread[sRow][sCol] == Integer.MAX_VALUE){
                System.out.println("NO");
            }
            else{
                if (minTime[eRow][eCol] != Integer.MAX_VALUE) System.out.println("NO");
                else System.out.println("YES");
            }
        }

        f.close();
    }

    public boolean outOfBounds(int r, int c, int rows, int cols){
        return r < 0 || r >= rows || c < 0 || c >= cols;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new volcano().run();
    }
}
