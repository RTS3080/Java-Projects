import java.util.*;
import java.io.*;

public class garold{
    public char checkWin(char[][] b) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] != '.' && b[i][0] == b[i][1] && b[i][0] == b[i][2]) {
                return b[i][0];
            }

            if (b[0][i] != '.' && b[0][i] == b[1][i] && b[0][i] == b[2][i]) {
                return b[0][i];
            }
        }

        if (b[0][0] != '.' && b[0][0] == b[1][1] && b[0][0] == b[2][2]) {
            return b[0][0];
        }

        if (b[0][2] != '.' && b[0][2] == b[1][1] && b[0][2] == b[2][0]) {
            return b[0][2];
        }

        return '.';
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("garold".toLowerCase()+".dat"));

        int times = f.nextInt();
        while (times-- > 0) {
            char[][] big = new char[9][9];
            char[][] board = new char[3][3];

            for (int i = 0; i < big.length; i++) {
                big[i] = f.next().toCharArray();
            }

            for (int i = 0; i < big.length; i+=3) {
                for (int j = 0; j < big[i].length; j+=3) {
                    char[][] tmp = new char[3][3];
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            tmp[k % 3][l % 3] = big[k][l];
                        }
                    }

                    board[i / 3][j / 3] = checkWin(tmp);
                }
            }
            char win = checkWin(board);
            if (win == '.') {
                System.out.println("Cat's Game.");
            } else {
                System.out.println("Player " + win + " Won.");
            }

            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i]);
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new garold().run();
    }
}