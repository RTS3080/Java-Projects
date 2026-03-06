import java.util.*;
import java.io.*;
import java.awt.*;

public class francisco{
    int[] rMove = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] cMove = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("francisco".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int numMoves = f.nextInt();
            int size = f.nextInt();

            int[][] mat = new int[size][size];
            for (int r = 0; r < size; r++){
                for (int c = 0; c < size; c++){
                    mat[r][c] = f.nextInt();
                }
            }

            HashSet<String> states = new HashSet<>();
            Queue<Object> q = new LinkedList<>();

            q.offer(mat); q.offer(0);

            int maxScore = Integer.MIN_VALUE;
            ArrayList<int[][]> list = new ArrayList<>();

            while (!q.isEmpty()){
                int[][] checkMat = (int[][]) q.poll();
                int depth = (int) q.poll();

                if (depth == numMoves+1) continue;

                String test = "";
                for (int r = 0; r < size; r++){
                    for (int c = 0; c < size; c++){
                        test += checkMat[r][c];
                    }
                }

                if (states.contains(test)) continue;
                states.add(test);

                int score = getScore(checkMat);
                if (score > maxScore){
                    maxScore = score;
                    list = new ArrayList<>();
                    list.add(checkMat);
                }
                else if (score == maxScore){
                    list.add(checkMat);
                }

                for (int r = 0; r < size; r++){
                    for (int c = 0; c < size; c++){
                        if (checkMat[r][c] == 0) continue;
                        for (int i = 0; i < 8; i++){
                            int tempR = r+rMove[i];
                            int tempC = c+cMove[i];
                            if (!inBounds(tempR, tempC, size)) continue;
                            if (checkMat[tempR][tempC] != 0) continue;

                            int[][] copy = copyMat(checkMat);
                            copy[tempR][tempC] = copy[r][c];
                            copy[r][c] = 0;
                            q.offer(copy); q.offer(depth+1);
                        }
                    }
                }
            }

            int len = list.size();

            System.out.println("MAXIMUM SCORE: "+maxScore);



            if (len == 1){
                System.out.println("THERE IS "+len+" OPTIMAL BOARD.");
                int[][] get = list.get(0);
                for (int r = 0; r < size; r++){
                    for (int c = 0; c < size; c++){
                        System.out.print(get[r][c]+" ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("THERE ARE "+len+" OPTIMAL BOARDS.");
            }

            System.out.println();
        }

        f.close();
    }

    public int[][] copyMat(int[][] mat){
        int[][] copy = new int[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++){
            for (int c = 0; c < mat[0].length; c++){
                copy[r][c] = mat[r][c];
            }
        }
        return copy;
    }

    public int getScore(int[][] mat){
        int score = 0;
        for (int r = 0 ; r < mat.length; r++){
            for (int c = 0 ; c < mat[r].length ; c++){
                if (mat[r][c] == 0) continue;
                for (int i = 0; i < 8; i++){
                    int tempR = r+rMove[i];
                    int tempC = c+cMove[i];

                    if (!inBounds(tempR, tempC, mat.length)) continue;
                    if (mat[tempR][tempC] == 0) continue;

                    if (mat[tempR][tempC] != mat[r][c]) score -= 5;
                    else score += 10;
                }
            }
        }

        return score;
    }

    public boolean inBounds(int r, int c, int size){
        return r >= 0 && r < size && c >= 0 && c < size;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new francisco().run();
    }
}
