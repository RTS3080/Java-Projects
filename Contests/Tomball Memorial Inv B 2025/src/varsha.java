import java.util.*;
import java.io.*;

public class varsha{
    char[][][] mat;

    public int recur(int l, int r, int c) {
        if (l < 0 || l >= mat.length || r < 0 || r >= mat[l].length || c < 0 || c >= mat[l][r].length || mat[l][r][c] != 'V')
            return 0;

        mat[l][r][c] = '.';
        return 1 + recur(l - 1, r, c) +
                recur(l + 1, r, c) +
                recur(l, r - 1, c) +
                recur(l, r + 1, c) +
                recur(l, r, c - 1) +
                recur(l, r, c + 1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("varsha".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int levels = f.nextInt();
            int rows = f.nextInt(); int cols = f.nextInt();
            f.nextLine();

            mat = new char[levels][rows][cols];
            for (int i = 0; i < levels; i++) {
                for (int j = 0; j < rows; j++) {
                    mat[i][j] = f.nextLine().trim().toCharArray();
                }
            }

            int best = 0;

            for (int i = 0; i < levels; i++) {
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols; k++) {
                        if (mat[i][j][k] == 'V') {
                            best = Math.max(recur(i, j, k), best);
                        }
                    }
                }
            }

            System.out.println(best);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new varsha().run();
    }
}
