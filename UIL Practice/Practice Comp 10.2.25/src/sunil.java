import java.util.*;
import java.io.*;
import java.awt.*;

public class sunil{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sunil".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int[][] board = new int[f.nextInt()][f.nextInt()];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = f.nextInt();
                }
            }

            double sum = 0;
            double[] rows = new double[board.length];
            double[] cols = new double[board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    rows[i] += board[i][j];
                    cols[j] += board[i][j];
                    sum += board[i][j];
                }
            }

            for (int i = 0; i < board.length; i++) {
                rows[i] /= board[i].length;
            }

            for (int i = 0; i < board[0].length; i++) {
                cols[i] /= board.length;
            }

            Arrays.stream(rows).forEach(x -> System.out.printf("%8.2f", x));
            System.out.println();
            Arrays.stream(cols).forEach(x -> System.out.printf("%8.2f", x));
            System.out.println();
            System.out.printf("%8.2f%n", sum / board.length / board[0].length);
            System.out.println("=".repeat(25));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sunil().run();
    }
}
