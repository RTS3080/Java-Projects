import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Podracing {
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("podracing.dat"));
        int times = f.nextInt();
        f.nextLine();

        while (times-- > 0) {
            int minTime = f.nextInt(), maxTime = f.nextInt(), rows = f.nextInt(), cols = f.nextInt();

            char[][] mat = new char[rows][cols];
            int sr = -1, sc = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            LinkedList<Integer> q = new LinkedList<>();
            q.add(sr); q.add(sc); q.add(0);
            int res = -1;
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();

                if (r < 0 || c < 0 || r >= rows || c >= cols || mat[r][c] == '#') {
                    continue;
                }

                if (t > maxTime) {
                    res = t;
                    break;
                }

                if (mat[r][c] == 'E') {
                    res = t;
                    break;
                }

                mat[r][c] = '#';

                q.add(r - 1); q.add(c); q.add(t + 1);
                q.add(r + 1); q.add(c); q.add(t + 1);
                q.add(r); q.add(c - 1); q.add(t + 1);
                q.add(r); q.add(c + 1); q.add(t + 1);
            }

            if (res < minTime) {
                System.out.println("\"Eat my exhausts!\"");
            } else if (res > maxTime) {
                System.out.println("\"You must have Jedi reflexes.\"");
            } else {
                System.out.println("\"Now this is podracing!\"");
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new Podracing().run();
    }
}