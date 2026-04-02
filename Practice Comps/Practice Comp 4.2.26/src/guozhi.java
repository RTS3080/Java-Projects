import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class guozhi{
    class Camera {
        int r;
        int c;
        int dr;
        int dc;

        public Camera(int r, int c, char d) {
            this.r = r;
            this.c = c;

            switch (d) {
                case 'N' -> dr = -1;
                case 'S' -> dr = 1;
                case 'E' -> dc = 1;
                case 'W' -> dc = -1;
            }
        }
    }

    public boolean inBounds(char[][][] mat, int r, int c) {
        return r >= 0 && r < mat[0].length && c >= 0 && c < mat[0][0].length;
    }

    public void setup(char[][][] mat, ArrayList<Camera> cams) {
        for (int i = 0; i < 4; i++) {
            for (Camera cam : cams) {
                int r = cam.r;
                int c = cam.c;
                int dr = cam.dr;
                int dc = cam.dc;

                while (inBounds(mat, r, c)) {
                    if (mat[0][r][c] == '#' || mat[0][r][c] == 'H') break;

                    mat[i][r][c] = 'X';
                    r += dr;
                    c += dc;
                }

                cam.dc = -dr;
                cam.dr = dc;
            }
        }
    }

    public int bfs(char[][][] mat, int sr, int sc) {
        boolean[][][] vis = new boolean[4][mat[0].length][mat[0][0].length];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(sr); q.add(sc); q.add(0);

        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            int t = q.poll();
            int rot = t % 4;

            if (!inBounds(mat, r, c)) continue;

            if (vis[rot][r][c]) continue;

            boolean bad = switch (mat[rot][r][c]) {
                case 'N', 'S', 'E', 'W', 'X', '#' -> true;
                default -> false;
            };

            if (bad) continue;

            if (mat[rot][r][c] == 'H') return t;

            vis[rot][r][c] = true;

            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                q.add(nr); q.add(nc); q.add(t + 1);
            }
        } return -1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("guozhi".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int rows = f.nextInt();
            int cols = f.nextInt();

            int sr = -1;
            int sc = -1;

            char[][][] mat = new char[4][rows][cols];

            ArrayList<Camera> cams = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                mat[0][i] = f.next().toCharArray();
                mat[1][i] = mat[0][i].clone();
                mat[2][i] = mat[0][i].clone();
                mat[3][i] = mat[0][i].clone();

                for (int j = 0; j < cols; j++) {
                    if (mat[0][i][j] == 'G') {
                        sr = i;
                        sc = j;
                    }

                    if ("NESW".contains("" + mat[0][i][j])) {
                        cams.add(new Camera(i, j, mat[0][i][j]));
                    }
                }
            }

            setup(mat, cams);

            int res = bfs(mat, sr, sc);

            System.out.println("Case #" + (times + 1) + ": " + res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new guozhi().run();
    }
}
