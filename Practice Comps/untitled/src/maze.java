import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class maze {

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("maze".toLowerCase()+".dat"));

        int times=f.nextInt();
        int ct = 1;
        timeloop:
        while(times-->0){
            char[][] mat = new char[20][20];
            LinkedList<Integer> q = new LinkedList<>();
            int sr = -1; int sc = -1;
            f.nextLine();

            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 'S') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            boolean solved = false;
            q.add(sr); q.add(sc);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || mat[r][c] == '#') continue;
                if (mat[r][c] == 'E') {
                    solved = true;
                    break;
                }
                mat[r][c] = '#';
                q.add(r - 1); q.add(c);
                q.add(r + 1); q.add(c);
                q.add(r); q.add(c - 1);
                q.add(r); q.add(c + 1);
            }
            System.out.print("Maze #" + ct++ + ": ");
            if (solved) System.out.println("YES");
            else System.out.println("NO");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new maze().run();
    }
}
