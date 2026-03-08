import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob31{
    // Diag down: (0, 0), (1, 1)
    // Diag up: (0, 4), (1, 3)

    public String check(boolean[][] board) {
        int[] rows = new int[5];
        int[] cols = new int[5];
        int diagUp = 0;
        int diagDown = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!board[i][j]) {continue;}
                if (i == j) diagDown++;
                if (i == 4 - j) diagUp++;

                rows[i]++;
                cols[j]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (rows[i] == 5) {
                return "Row " + i;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (cols[i] == 5) {
                return "Column " + i;
            }
        }

        if (diagDown == 5) {
            return "Diag Down";
        }

        if (diagUp == 5) {
            return "Diag Up";
        } return "";
    }

    public void run() throws FileNotFoundException {
        //Scanner f= new Scanner(new File("prob31".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        Scanner cf = new Scanner(new File(f.next()));
        Scanner gf = new Scanner(new File(f.next()));
        f.close();

        int N = cf.nextInt();
        cf.nextLine();
        HashMap<String, int[]>[] cardWords = new HashMap[N];
        boolean[][][] cardBoards = new boolean[N][5][5];
        String[][][] cards = new String[N][5][5];

        for (int idx = 0; idx < N; idx++) {
            cardWords[idx] = new HashMap<>();
            String[] words = cf.nextLine().trim().split(" ");

            for (int i = 0; i < 24; i++) {
                int r, c;
                if (i >= 12) {
                    r = (i + 1) / 5;
                    c = (i + 1) % 5;
                } else {
                    r = i / 5;
                    c = i % 5;
                }

                cardWords[idx].put(words[i], new int[]{r, c});
                cards[idx][r][c] = words[i];
            }

            cards[idx][2][2] = "*";
            cardBoards[idx][2][2] = true;
        }

        cf.close();

        loop:
        while (gf.hasNext()) {
            String word = gf.next();
            for (int cardIdx = 0; cardIdx < N; cardIdx++) {
                HashMap<String, int[]> words = cardWords[cardIdx];
                boolean[][] card = cardBoards[cardIdx];
                String[][] board = cards[cardIdx];

                int[] coord = words.get(word);
                if (coord == null) continue;
                int r = coord[0];
                int c = coord[1];

                card[r][c] = true;

                String res = check(card);

                if (res.isEmpty()) {
                    continue;
                }

                String[] tokens = res.split(" ");
                String wordList = "";
                if (tokens[0].equals("Row")) {
                    int row = Integer.parseInt(tokens[1]);

                    for (int i = 0; i < 5; i++) {
                        wordList += board[row][i] + " ";
                    }
                }

                else if (tokens[0].equals("Column")) {
                    int col = Integer.parseInt(tokens[1]);

                    for (int i = 0; i < 5; i++) {
                        wordList += board[i][col] + " ";
                    }
                }

                else if (tokens[1].equals("Down")) {
                    wordList = board[0][0] + " " + board[1][1] + " " + board[2][2] + " " + board[3][3] + " " + board[4][4];
                } else {
                    wordList = board[0][4] + " " + board[1][3] + " " + board[2][2] + " " + board[3][1] + " " + board[4][0];
                }

                System.out.println("Card " + cardIdx + " wins " + res + " " + wordList.trim());

                break loop;
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob31().run();
    }
}
