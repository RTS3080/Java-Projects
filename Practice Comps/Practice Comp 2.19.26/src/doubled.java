import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class doubled{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("doubled".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            char player = f.next().charAt(0);
            char nonplayer = player == 'B' ? 'R' : 'B';
            boolean isDoubled = false;

            char[][] grid = new char[6][7];
            for (int r = 0; r < grid.length; r++){
                grid[r] = f.next().toCharArray();
            }

            for (int i = 0; i < 7; i++){
                int height = 5;
                while (height >= 0 && grid[height][i] != '.'){
                    height--;
                }
                if (height != -1){
                    grid[height][i] = player;
                    for (int j = 0; j < 7; j++){
                        int height1 = 5;
                        while (height1 >= 0 && grid[height1][j] != '.'){
                            height1--;
                        }
                        if (height1 != -1) {
                            grid[height1][j] = nonplayer;

//                            for (char[] each:grid) System.out.println(each);
//                            System.out.println("-".repeat(10));

                            isDoubled |= checkGrid(grid, nonplayer);

//                            if (isDoubled){
//                                for (char[] each:grid) System.out.println(each);
//                            }
                            grid[height1][j] = '.';
                        }
                        grid[height1][j] = '.';
                    }
                    grid[height][i] = '.';

                }
            }

            if (isDoubled){
                System.out.println("Doubled!");
            }
            else{
                System.out.println("There's hope");
            }
//            System.out.println(isDoubled);
        }
        f.close();
    }


    public boolean checkGrid(char[][] grid, char check){
        int[] rMove = {-1, 0, 0, 1};
        int[] cMove = {0, -1, 1, 0};

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                for (int i = 0; i < 4; i++) {
                    int connected = 0;

                    int tempR = r ;
                    int tempC = c;

                    while (true) {
                        if (tempR < 0 || tempR >= grid.length || tempC < 0 || tempC >= grid[0].length) break;
                        if (connected == 4) break;
                        if (grid[tempR][tempC] != check) break;

                        connected++;
                        tempR += rMove[i];
                        tempC += cMove[i];
                    }

                    if (connected == 4) return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new doubled().run();
    }
}
