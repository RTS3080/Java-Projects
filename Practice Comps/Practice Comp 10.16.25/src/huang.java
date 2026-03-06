import java.util.*;
import java.io.*;
import java.awt.*;

public class huang{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("huang".toLowerCase()+".dat"));

        while (f.hasNext()) {
            char[] word = f.next().toCharArray();
            int size = f.nextInt();
            char[][] mat = new char[size][size];
            int lb = 0;
            int rb = size - 1;
            int tb = 0;
            int bb = size - 1;
            int dx = 0;
            int dy = 1;
            int x = 0;
            int y = 0;
            int idx = 0;
            while (mat[size / 2][size / 2] == 0) {
                while (lb <= x && rb >= x && tb <= y && bb >= y && mat[x][y] == 0) {
                    mat[x][y] = word[idx++ % word.length];
                    x += dx;
                    y += dy;
                }

                x -= dx;
                y -= dy;

//                System.out.println(dx + " " + dy);
                int t = dy;
                dy = dx;
                dx = -t;

                x += dx;
                y += dy;
            }

            mat[size / 2][size / 2] = '*';
            for (char[] row : mat) {
                System.out.println(row);
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new huang().run();
    }
}
