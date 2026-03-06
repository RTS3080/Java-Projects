import java.util.*;
import java.io.*;
import java.awt.*;

public class aliens{

    int rows, cols, time;

    HashMap<Character, int[]> portals;

    char[][] maze;
    int[][][] sMaze;


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("aliens".toLowerCase()+".dat"));


        int cases = f.nextInt();
        while (cases-- > 0){
            rows = f.nextInt();
            cols = f.nextInt();
            time = f.nextInt();

            f.nextLine();

            maze = new char[rows][cols];


            int startR = 0, startC = 0;
            int endR = 0, endC = 0;

            portals = new HashMap<>();

            for (int r = 0; r < rows; r++){
                maze[r] = f.nextLine().toCharArray();
                for (int c = 0; c < cols; c++) {
                    if (maze[r][c] == '@') {
                        startR = r;
                        startC = c;
                    }

                    if (maze[r][c] == '?') {
                        endR = r;
                        endC = c;
                    }

                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" + maze[r][c])) {
                        portals.put(maze[r][c], new int[]{-1, -1});
                    }

                }
            }

            for (int r = 0; r < rows; r++){
                for (int c = 0; c < cols; c++) {
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().contains("" + maze[r][c])) {
                        if (portals.containsKey(Character.toUpperCase(maze[r][c]))) {
                            portals.put(Character.toUpperCase(maze[r][c]), new int[]{r, c});
                        }
                    }
                }
            }

            for (char each : portals.keySet()){
                if (portals.get(each)[0] == -1) portals.remove(each);
            }

            sMaze = new int[1 << 9][rows][cols];
            for (int i = 0; i < (1 << 9); i++){
                for (int r = 0; r < rows; r++){
                    Arrays.fill(sMaze[i][r], Integer.MAX_VALUE);
                }

            }

            recur(startR, startC, 0, 0);

            for (int i = 0; i < (1 << 9); i++){
                for (int r = 0; r < rows; r++){
//                    System.out.println(Arrays.toString(sMaze[i][r]));
                }
//                System.out.println("-".repeat(10));

            }

                int result = Integer.MAX_VALUE;

            for (int i = 0; i < 1 << 9; i++){
                result = Math.min(result, sMaze[i][endR][endC]);
            }

//            System.out.println(result);
//            System.out.println(time);

            System.out.println(result >= time ? "In space, no one can hear you scream." :
                    "I admire its purity. A survivor... unclouded by conscience, remorse, or delusions of morality.");
        }

        f.close();
    }

    public void recur(int r, int c, int state, int t){
        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (sMaze[state][r][c] <= t) return;
        if (maze[r][c] == '#') return;

        sMaze[state][r][c] = t;

        int ind = "123456789".indexOf(""+maze[r][c]);

        if (ind >= 0){
            if ( ((1 << ind) & state) == 0) {
                state = (1 << ind) | state;

                char prev = maze[r][c];

                maze[r][c] = '.';
                recur(r, c, state, t - (maze[r][c] - '0'));
                maze[r][c] = prev;

                return;
            }
        }

        if (portals.containsKey(maze[r][c])){
            int[] coord = portals.get(maze[r][c]);
            recur(coord[0], coord[1], state, t);

            return;
        }

        recur(r+1, c, state, t + 1);
        recur(r-1, c, state, t + 1);
        recur(r, c+1, state, t + 1);
        recur(r, c-1, state, t + 1);

    }



    public static void main(String[] args) throws FileNotFoundException{
        new aliens().run();
    }
}
