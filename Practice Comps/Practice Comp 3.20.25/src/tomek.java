import java.util.*;
import java.io.*;

public class tomek{
    char[][] mat;
    boolean valid;

    public int recur(int r, int c) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || !valid) {
            valid = false;
            return Integer.MIN_VALUE;
        }

        if (mat[r][c] == 'W') {
            return 0;
        }

        mat[r][c] = 'W';
        return 1 + recur(r - 1, c) + recur(r, c - 1) + recur(r + 1, c) + recur(r, c + 1);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tomek".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        for (int ti = 0; ti < times; ti++) {
            System.out.print("Case #" + (ti + 1) + ": ");
            int rows = f.nextInt();
            int cols = f.nextInt();

            f.nextLine();

            mat = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                mat[i] = f.nextLine().toCharArray();
            }

            int prov = 0;
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == '.') {
                        valid = true;
                        int size = recur(i, j);
                        if (!valid || size < 0) continue;
                        prov++;
                        res.add(-size);
                    }
                }

            }

            Collections.sort(res);
            String st = "";
            for (Integer re : res) {
                st += (-re) + " ";
            }

            System.out.println(prov);
            System.out.println(st.trim().isEmpty() ? "NONE" : st.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tomek().run();
    }
}
