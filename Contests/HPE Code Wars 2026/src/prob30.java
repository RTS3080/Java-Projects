import java.util.*;
import java.io.*;


public class prob30{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob30".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));

        ROWS = f.nextInt();
        M = f.nextInt();

        result = new char[ROWS][ROWS];

        found = false;

        char[][] grid = new char[ROWS][ROWS];
        for (int r = 0; r < ROWS; r++) grid[r] = f.next().toCharArray();

//        System.out.println(Arrays.deepToString(grid));

        recur(0, 0, 0, grid);

        for (char[] each:result) System.out.println(each);

        f.close();
    }

    int ROWS;
    int M;
    boolean found;

    char[][] result;


    public void recur(int r, int c, int numMs, char[][] grid){
        if (found) return;

        if (numMs > M) return;
        if (r == ROWS){
            boolean valid = true;
            for (int tr = 0; tr < ROWS; tr++){
                for (int tc = 0; tc < ROWS; tc++){
                    if (inBounds(tr, tc) && Character.isDigit(grid[tr][tc])){

                        int target = grid[tr][tc] - '0';
                        int tempM = 0;

                        for (int inR = tr-1; inR <= tr+1; inR++){
                            for (int inC = tc-1; inC <= tc+1; inC++){
                                if (inBounds(inR, inC) && grid[inR][inC] == 'M') tempM++;
                            }
                        }

                        if (tempM < target || tempM > target) valid = false;
                    }
                }
            }

            if (valid && numMs == M){
                found = true;
                result = grid;
            }
            return;

        }
        if (c == ROWS){
            char[][] copy = copy(grid);
            recur(r +1, 0, numMs, copy);
            return;
        }

        if (grid[r][c] == '.'){
            char[][] copy = copy(grid);
            copy[r][c] = 'M';
            boolean valid = true;
            for (int tr = r-1; tr <= r+1; tr++){
                for (int tc = c-1; tc <= c+1; tc++){
                    if (inBounds(tr, tc) && Character.isDigit(copy[tr][tc])){

                        int target = copy[tr][tc] - '0';
                        int tempM = 0;

                        for (int inR = tr-1; inR <= tr+1; inR++){
                            for (int inC = tc-1; inC <= tc+1; inC++){
                                if (inBounds(inR, inC) && copy[inR][inC] == 'M') tempM++;
                            }
                        }

                        if (tempM > target) valid = false;
                    }
                }
            }

            if (valid) recur(r, c+1, numMs+1, copy);

            copy = copy(grid);

            recur(r, c+1, numMs, copy);

            return;
        }

        else{
            char[][] copy = copy(grid);
            recur(r, c+1, numMs, copy);
        }
    }

    public boolean inBounds(int r, int c){
        return r >= 0 && r < ROWS && c >= 0 && c < ROWS;
    }

    public char[][] copy(char[][] grid){
        char[][] copy = new char[ROWS][ROWS];
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < ROWS; c++){
                copy[r][c] = grid[r][c];
            }
        }
        return copy;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new prob30().run();
    }
}
