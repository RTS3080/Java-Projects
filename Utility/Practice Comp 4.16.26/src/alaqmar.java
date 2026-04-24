import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class alaqmar{
    public int dfs(char[][] mat, int[][][] shadow, ArrayList<int[]> portals, int sr, int sc) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(sr); q.add(sc); q.add(0);

        while (!q.isEmpty()) {
            int b = q.poll();
            int r = q.poll();
            int c = q.poll();
            int step = q.poll();

            if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length) continue;

            if (mat[r][c] == '#') continue;

            if (mat[r][c] < 32) {
                int idx = mat[r][c];
                b |= 1 << idx;
            }

            if (step >= shadow[b][r][c]) continue;

            if (b == shadow.length - 1 && mat[r][c] == 'E') {
                return step;
            }

            shadow[b][r][c] = step;

            if (mat[r][c] == 'O') {
                for (int[] portal : portals) {
                    q.add(b); q.add(portal[0]); q.add(portal[1]); q.add(step + 1);
                }
            }

            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : dirs) {
                q.add(b); q.add(r + dir[0]); q.add(c + dir[1]); q.add(step + 1);
            }
        } return -1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("alaqmar".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            int maxTime = f.nextInt();

            char[][] mat = new char[r][c];

            int sr = -1, sc = -1;

            ArrayList<int[]> portals = new ArrayList<>();

            int printers = 0;

            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }

                    if (mat[i][j] == 'P') mat[i][j] = (char) printers++;
                    if (mat[i][j] == 'O') portals.add(new int[]{i, j});
                }
            }

            int[][][] shadow = new int[1 << printers][r][c];

            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }

            int res = dfs(mat, shadow, portals, sr, sc);

            if (res == -1 || res > maxTime) {
                System.out.println("Should have woken up sooner!");
            } else {
                System.out.println("Heheheha, made it safely in " + res + " step(s).");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new alaqmar().run();
    }
}
