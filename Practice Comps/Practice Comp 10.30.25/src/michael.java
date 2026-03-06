import java.util.*;
import java.io.*;
import java.awt.*;

public class michael{
    public void place(char[][] board, int piece, char[][] quinto, int[] ref, int r, int c) {
        int ri = r - ref[0];
        int ci = c - ref[1];

        for (int i = 0; i < quinto.length; i++) {
            for (int j = 0; j < quinto[i].length; j++) {
                if (quinto[i][j] == ' ') continue;
                board[i + ri][j + ci] = quinto[i][j];
            }
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("michael".toLowerCase()+".dat"));

        while (f.hasNext()) {
            char[][][] quintos = new char[][][] {
                {
                    "AAA".toCharArray(),
                    "A  ".toCharArray(),
                    "R  ".toCharArray()
                },

                {
                    "B ".toCharArray(),
                    "BB".toCharArray(),
                    "RB".toCharArray()
                },

                {
                    "CCCR".toCharArray(),
                    "   C".toCharArray()
                }
            };

            int[][] refPoints = new int[][] {
                    {2, 0}, {2, 0}, {0, 3}
            };

//            for (int i = 0; i < quintos.length; i++) {
//                for (int j = 0; j < quintos[i].length; j++) {
//                    System.out.println(quintos[i][j]);
//                }
//            }

            char[][] board = new char[8][8];

            for (char[] row : board) {
                Arrays.fill(row, '.');
            }

            int n = f.nextInt();

            for (int i = 0; i < n; i++) {
                int piece = f.next().charAt(0) - 'A';
                int c = f.nextInt() - 1;
                int r = f.nextInt() - 1;

                place(board, piece, quintos[piece], refPoints[piece], r, c);
            }

            int c = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] != '.') {
                        c++;
                    }
                }
            }

            System.out.println(c);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new michael().run();
    }
}
