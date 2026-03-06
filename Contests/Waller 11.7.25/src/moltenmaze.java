import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class moltenmaze{
    public void lavaFill(int sr, int sc, int[][] shad, char[][] mat) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(sr); q.add(sc); q.add(0);

        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            int step = q.poll();

            if (r < 0 || c < 0 || r >= shad.length || c >= shad[r].length) {
                continue;
            }

            if (step >= shad[r][c]) continue;
            if (mat[r][c] == '#') {
                continue;
            }

            shad[r][c] = step;

            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                q.add(nr); q.add(nc); q.add(step + 1);
            }
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("moltenmaze".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();

            char[][] mat = new char[rows][cols];
            int[][] lava = new int[rows][cols];

            int sr = -1, sc = -1;

            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(lava[i], Integer.MAX_VALUE);

                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'L')
                        lavaFill(i, j, lava, mat);
                }
            }

            boolean result = false;
            LinkedList<Integer> q = new LinkedList<>();
            q.add(sr); q.add(sc); q.add(0);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int step = q.poll();

                if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length) continue;
                if (step >= lava[r][c]) continue;
                if (mat[r][c] == '#') continue;

                if (mat[r][c] == 'E') {
                    result = true;
                    break;
                }

                mat[r][c] = '#';

                int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    q.add(nr); q.add(nc); q.add(step + 1);
                }
            }

            if (result) {
                System.out.println("Comin in hot!");
            } else
                System.out.println("I'm cooked");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new moltenmaze().run();
    }
}
