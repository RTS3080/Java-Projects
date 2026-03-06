import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class minehunt{
    char[][] field;
    int[][] counts;
    boolean[][] revealed;
    boolean[][] revealed2;

    public boolean inBounds(int r, int c) {
        return 0 <= r && r < 20 && 0 <= c && c < 20;
    }

    public int countMines(int r, int c) {
        if (field[r][c] == '@') {
            return -1;
        }

        int count = 0;

        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                if (inBounds(i, j) && field[i][j] == '@') {
                    count++;
                }
            }
        }

        return count;
    }

    public void fill(int r, int c) {
        if (!inBounds(r, c)) return;
        if (revealed[r][c]) return;


        revealed[r][c] = true;

        if (field[r][c] != '@') {
            int count = counts[r][c];
            if (count == 0) {
                field[r][c] = '.';
            } else {
                field[r][c] = (char) ('0' + count);
            }
        }

        if (counts[r][c] != 0) {
            return;
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            fill(nr, nc);
        }

        dirs = new int[][] {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (inBounds(nr, nc)) {
                revealed2[nr][nc] = true;

                if (field[nr][nc] != '@') {
                    int count = counts[nr][nc];
                    if (count == 0) {
                        field[nr][nc] = '.';
                    } else {
                        field[nr][nc] = (char) ('0' + count);
                    }
                }
            }
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("minehunt".toLowerCase()+".dat"));

        field = new char[20][20];
        counts = new int[20][20];
        revealed = new boolean[20][20];
        revealed2 = new boolean[20][20];

        for (int i = 0; i < 20; i++) {
            field[i] = f.next().toCharArray();
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                counts[i][j] = countMines(i, j);
            }
        }

        while (f.hasNext()) {
            int r = f.nextInt() - 1;
            int c = f.nextInt() - 1;
            fill(r, c);
        }

        char[][] out = new char[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (revealed[i][j] || revealed2[i][j]) {
                    out[i][j] = field[i][j];
                } else {
                    out[i][j] = 'x';
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(out[i]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new minehunt().run();
    }
}

/*
C:\Users\ryder\.jdks\openjdk-21.0.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2023.3.6\lib\idea_rt.jar=57141:C:\Program Files\JetBrains\IntelliJ IDEA 2023.3.6\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\ryder\IdeaProjects\Practice Comps\Code Wars Practice 3.5.26\out\production\Code Wars Practice 3.5.26" minehunt
xxx......1xxxxxxxxxx
xxx1..1122xxxxxxxxxx
xxx1..2xxxxxxxxxxxxx
xxx2113xxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxx@xx1xxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxxx
xxxxxxxx3112xxxxxxxx
xxxxxx211..1xxxxxxxx
xxxx211....1xxxxxxxx
xxxx2......1xxxxxxxx
xxxx2111.112xxxxxxxx
xxxxxxx1.1xxxxxxxxxx
xxxxxxx1.1xxxxxxxxxx

Process finished with exit code 0

 */