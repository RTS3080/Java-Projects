import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class gridsearch{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gridsearch".toLowerCase()+".dat"));

        int[] rMove = new int[]{-1, 0, 0, 1};
        int[] cMove = new int[]{0, -1, 1, 0};

        String[] dirs = new String[]{"up", "left", "right", "down"};

        int N = f.nextInt();
        char[][] grid = new char[N][N];

        for (int r = 0; r < N; r++) {
            grid[r] = f.next().toCharArray();
        }

        int numQueries = f.nextInt();
        String[] queries = new String[numQueries];
        for (int i = 0; i < numQueries; i++) {
            queries[i] = f.next();
        }



        for (String each : queries){
            ArrayList<int[]> results = new ArrayList<>();

            for (int r = 0; r < N; r++){
                for (int c = 0; c < N; c++){
                    for (int i = 0; i < 4; i++){
                        int tempR = r;
                        int tempC = c;
                        int ind = 0;
                        boolean found = false;

                        while (true){
                            if (ind == each.length()){
                                found = true;
                                break;
                            }
                            if (tempR < 0 || tempR >= N || tempC < 0 || tempC >= N) break;
                            if (each.charAt(ind) != grid[tempR][tempC]) break;
                            ind++;
                            tempR += rMove[i];
                            tempC += cMove[i];
                        }

                        if (found) {
                            results.add(new int[]{r, c, i});
                        }
                    }
                }
            }

            StringBuilder print = new StringBuilder();
            print.append(each).append(" ");
            for (int[] check : results){
                print.append(check[0]+1).append(",").append(check[1]+1).append(",").append(dirs[check[2]]).append(" ");
            }

            System.out.println(print.toString().trim());
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new gridsearch().run();
    }
}
