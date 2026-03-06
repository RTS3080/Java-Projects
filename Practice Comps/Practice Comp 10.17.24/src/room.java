import java.util.*;
import java.io.*;

public class room{
    char[][] mat;

    public int recur(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == '#')
            return 0;

        mat[r][c] = '#';
        return 1 + recur(r - 1, c) +
            recur(r + 1, c) +
            recur(r, c - 1) +
            recur(r, c + 1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("room".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();

            mat = new char[rows][cols];
            int sr = -1;
            int sc = -1;
            f.nextLine();
            for (int i = 0; i < rows; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                }
            }

            System.out.println("$"+recur(sr, sc));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new room().run();
    }
}
