import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class memory{
    public boolean isEmpty(ArrayList<Character>[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].isEmpty()) {
                    return false;
                }
            }
        } return true;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("memory".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            int depth = f.nextInt();

            ArrayList<Character>[][] board = new ArrayList[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < rows; j++) {
                    String str = f.next();
                    int k = 0;

                    for (char ch : str.toCharArray()) {
                        board[j][k++].add(ch);
                    }
                }
            }

            while (!isEmpty(board)) {
                HashMap<Character, int[]> seen = new HashMap<>();

                boolean foundMatch = false;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[i][j].isEmpty()) continue;

                        if (seen.containsKey(board[i][j].getFirst())) {
                            foundMatch = true;
                            int[] coords = seen.get(board[i][j].getFirst());
                            board[i][j].removeFirst();
                            board[coords[0]][coords[1]].removeFirst();
                            continue;
                        } else {
                            seen.put(board[i][j].getFirst(), new int[] {i, j});
                        }
                    }
                }

                if (!foundMatch) break;
            }

//            for (int i = 0; i < rows; i++) {
//                System.out.println(Arrays.toString(board[i]));
//            }

            if (isEmpty(board)) System.out.println("solvable");
            else System.out.println("impossible");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new memory().run();
    }
}
