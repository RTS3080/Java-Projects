import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class logan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("logan".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int max = Integer.MIN_VALUE;
            int r = f.nextInt();
            int c = f.nextInt();
            int threshold = f.nextInt();
            int[][] grid = new int[r][c];
            char[][] mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(mat[i], '.');
                for (int j = 0; j < c; j++) {
                    grid[i][j] = f.nextInt();
                    if(grid[i][j] >= threshold){
                        mat[i][j] = 'X';
                    }
                    if(grid[i][j] > max){
                        max = grid[i][j];
                    }
                }
            }
            ArrayList<int[]> locs = new ArrayList<>();
            for (int i = 0; i <r; i++) {
                for (int j = 0; j < c; j++) {
                    if(grid[i][j] == max){
                        locs.add(new int[]{i+1,j+1});
                    }
                }
            }

            System.out.println("--- Hazard Map Case "+times+" ---");
            System.out.println("Grid:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.printf("%3d", grid[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("Smelliest value: "+max);
            String resLocs = "";
            for(int[] loc : locs){
                resLocs+="("+loc[0]+","+loc[1]+") ";
            }
            System.out.println("Location(s)  : "+resLocs.trim());
            System.out.println();
            System.out.println("Danger map:");
            for (int i = 0; i < r; i++) {
                String out = "";
                for (int j = 0; j < c; j++) {
                    out+=mat[i][j]+" ";
                }
                System.out.println(out.trim());
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new logan().run();
    }
}
