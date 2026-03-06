import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class missing{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("missing".toLowerCase()+".dat"));

        int[] rMoves = new int[]{-1, 0, 0, 1};
        int[] cMoves = new int[]{0, -1, 1, 0};

        while (f.hasNext()){
            f.next();
            int D = f.nextInt();
            int N = f.nextInt();

            String[][] current = new String[D][D];

            for (int r = 0; r < D; r++){
                for (int c = 0; c < D; c++){
                    current[r][c] = f.next();
                }
            }

            String[][] solved = new String[D][D];

            for (int r = 0; r < D; r++){
                for (int c = 0; c < D; c++){
                    solved[r][c] = f.next();
                }
            }

            String solvedStr = convert(solved);


            HashMap<String, Integer> map = new HashMap<>();
            Queue<Object> q = new LinkedList<>();

            map.put(convert(current), 0);
            q.offer(current); q.offer(0);

            int maxSize = 0;

            while (!q.isEmpty()){
                if (map.size() > maxSize){
//                    System.out.println(map);
                    maxSize = map.size();
                }
//                System.out.println(q);
                String[][] grid = (String[][]) q.poll();
                int moves = (int) q.poll();

                if (moves > N) continue;

                int xR = 0, xC = 0;

                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[r].length; c++) {
                        if (grid[r][c].equals("X")) {
                            xR = r;
                            xC = c;
                        }
                    }
                }

                for (int i = 0; i < 4; i++){
                    String[][] copyGrid = new String[D][D];

                    for (int r = 0; r < D; r++){
                        for (int c = 0; c < D; c++){
                            copyGrid[r][c] = grid[r][c];
                        }
                    }

                    int tempR = xR+rMoves[i];
                    int tempC = xC+cMoves[i];

                    if (tempR < 0 || tempR >= D || tempC < 0 || tempC >= D) continue;
                    copyGrid[xR][xC] = copyGrid[tempR][tempC];
                    copyGrid[tempR][tempC] = "X";


                    String strGrid = convert(copyGrid);
                    if (map.containsKey(strGrid) && map.get(strGrid) <= moves+1) continue;
                    map.put(strGrid, moves+1);

                    q.offer(copyGrid); q.offer(moves+1);
                }
            }


            if (map.containsKey(solvedStr)){
                System.out.println("SOLVABLE WITHIN "+map.get(solvedStr)+" MOVES");
            }
            else {
                System.out.println("NOT SOLVABLE WITHIN "+N+" MOVES");
            }

            System.out.println();
            f.next();

//            System.out.println(convert(solved));
        }

        f.close();
    }

    public String convert(String[][] mat){
        String result = "";
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                result += mat[r][c] + "|";
            }
        }
        return result.substring(0, result.length() - 1);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new missing().run();
    }
}
