import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class othello{
    public boolean checkBounds(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("othello".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char[][] board = new char[8][8];

            for (int i = 0; i < 8; i++) {
                board[i] = f.next().toCharArray();
            }

            int r = f.nextInt();
            int c = f.nextInt();
            char ch = f.next().charAt(0);

            boolean didFill = false;
            int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

            for (int[] dir : dirs) {
                int dr = dir[0];
                int dc = dir[1];

                int nr = r;
                int nc = c;


                if (!checkBounds(nr + dr, nc + dc) || board[nr + dr][nc + dc] == ch) {
                    continue;
                }


                boolean fill = false;
                board[r][c] = ch;
                nr = r + dr;
                nc = c + dc;

                while (checkBounds(nr, nc)) {
                    if (board[nr][nc] == ch) {
                        fill = true;
                        break;
                    } nr += dr; nc += dc;
                }


                if (fill) {
                    board[r][c] = ch;
                    nr = r + dr;
                    nc = c + dc;
                    while (checkBounds(nr, nc)) {
                        if (board[nr][nc] == ch) {
                            break;
                        }

                        board[nr][nc] = ch;
                        didFill = true;
                        nr += dr;
                        nc += dc;
                    }
                }
            }

            if (!didFill) {
                System.out.println("Invalid Move");
            } else {
                for (char[] row : board) {
                    System.out.println(row);
                }
            }

            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new othello().run();
    }
}
