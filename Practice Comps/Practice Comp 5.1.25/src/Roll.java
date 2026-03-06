import java.util.*;
import java.io.*;
import java.awt.*;

public class Roll{
    char[][] mat;
    int n;
    public void rot(int depth){
        if (n/2 < depth)
            return;

        int end = n-depth;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int dir = 0;
        int x = depth;
        int y = depth;
        char temp = mat[depth][depth];
        while (dir < 4){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!(nx >= depth && ny >= depth && nx < end && ny < end))
            {
                dir++;
                if (dir == 4)
                    break;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            mat[y][x] = mat[ny][nx];
            x = nx;
            y = ny;
        }
        mat[y][x] = temp;
        rotrev(depth+1);
    }
    public void rotrev(int depth){
        if (n/2 < depth)
            return;

        int end = n-depth;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int dir = 0;
        int x = depth;
        int y = depth;
        char temp = mat[depth][depth];
        while (dir < 4){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!(nx >= depth && ny >= depth && nx < end && ny < end))
            {
                dir++;
                if (dir == 4)
                    break;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            mat[y][x] = mat[ny][nx];
            x = nx;
            y = ny;
        }
        mat[y][x] = temp;
        rot(depth+1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Roll".toLowerCase()+".dat"));
        int cses = f.nextInt();
        f.nextLine();
        for (int tst = 0; tst < cses; tst++) {
            String s = f.nextLine();
            n = (int)Math.sqrt(s.length());
            mat = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.charAt(i*n+j);
                }
            }
            rotrev(0);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j]);
                }
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Roll().run();
    }
}
