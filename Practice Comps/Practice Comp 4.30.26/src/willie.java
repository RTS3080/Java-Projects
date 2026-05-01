import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class willie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("willie".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();
            f.nextLine();

            String[][] grid = new String[N][N];
            for (int i = 0; i < N; i++){
                f.nextLine();
                f.next();
                String[] temp = f.nextLine().trim().split("\\|");
                for (int j = 0; j < N; j++) temp[j] = temp[j].strip();
                grid[i] = temp;
//                System.out.println(Arrays.toString(temp));
            }

//            for (int i = 0; i < N; i++){
//                String[] temp = new String[N];
//                for (int j = 1; j <= N; j++) temp[j] = grid[i][j-1];
//                grid[i] = temp;
//            }

//            for (String[] each:grid) System.out.println(Arrays.toString(each));

            int[] row = new int[N];
            int[] col = new int[N];
            int[] LTRB = new int[2*N-1];
            int[] LBRT = new int[2*N-1];
            int numQueens = 0;

            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    if (grid[r][c].equals("Q")){
                        numQueens++;
                        row[r]++;
                        col[c]++;
                        LTRB[c-r+(N-1)]++;
                        LBRT[c+r]++;
                    }
                }
            }

//            System.out.println(Arrays.toString(row));
//            System.out.println(Arrays.toString(col));
//
//            System.out.println(Arrays.toString(LBRT));
//            System.out.println(Arrays.toString(LTRB));

            f.nextLine();
            f.nextLine();

            boolean valid = true;
            if (numQueens != N) valid = false;
            for (int each : row)
                if (each > 1) valid = false;
            for (int each : col)
                if (each > 1) valid = false;
            for (int each : LTRB)
                if (each > 1) valid = false;
            for (int each : LBRT)
                if (each > 1) valid = false;

            System.out.println(valid ? "valid solution" : "incorrect attempt");

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new willie().run();
    }
}
