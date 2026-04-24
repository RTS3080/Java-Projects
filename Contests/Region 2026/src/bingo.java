import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bingo{
    public void fill(int num, int[][] granny, int[][]...boards) {
        for (int i = 0; i < granny.length; i++) {
            for (int j = 0; j < granny.length; j++) {
                if (granny[i][j] == num)
                    granny[i][j] = 0;
            }
        }

        for (int[][] board : boards) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == num)
                        board[i][j] = 0;
                }
            }
        }
    }

    public boolean check(int[][] board) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 5; i++) {
            int sum3 = 0;
            int sum4 = 0;

            sum1 += board[i][i];
            sum2 += board[i][board[i].length - 1 - i];

            for (int j = 0; j < 5; j++) {
                sum3 += board[i][j];
                sum4 += board[j][i];
            }

            if (sum3 == 0 || sum4 == 0) return true;
        }

        return sum1 == 0 || sum2 == 0;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bingo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int[][] granny = new int[5][5];
        int[][] orig = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                orig[i][j] = granny[i][j] = f.nextInt();
            }
        }

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int[][][] boards = new int[f.nextInt()][5][5];

            long seed = f.nextLong();
            Random rand = new Random(seed);

            int[][][] copy = new int[boards.length][5][5];

            for (int i = 0; i < boards.length; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        copy[i][j][k] = boards[i][j][k] = f.nextInt();
                    }
                }
            }

            int grannyWins = 0;

            loop:
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        granny[j][k] = orig[j][k];
                    }
                }

                for (int j = 0; j < boards.length; j++) {
                    for (int k = 0; k < 5; k++) {
                        for (int l = 0; l < 5; l++) {
                            boards[j][k][l] = copy[j][k][l];
                        }
                    }
                }

                while (true) {
                    int num = rand.nextInt(1, 76);

                    fill(num, granny, boards);

                    if (check(granny)) {
                        grannyWins++;
                        continue loop;
                    }

                    for (int[][] board : boards) {
                        if (check(board)) continue loop;
                    }
                }
            }

            System.out.println(grannyWins / 10. + "% Win Rate.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bingo().run();
    }
}
