import java.util.*;
import java.io.*;

public class romina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("romina".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int rows=f.nextInt(); int cols=f.nextInt();
            int[][] mat = new int[rows][cols];
            int left = -1, up = -1, down = rows, right = cols;

            char dir = 'r';
            int r = 0, c = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = f.nextInt();
                }
            }

            while (left < c && up < r && right > c && down > r) {
                if (dir == 'r') {
                    int sum = 0;
                    double len = 0;

                    while (c < right) {
                        sum += mat[r][c];
                        c++;
                        len++;
                    }
                    c--;
                    up++;
                    System.out.printf("%.2f ", sum / len);
                    dir = 'd';
                    r++;
                } else if (dir == 'd') {
                    int sum = 0;
                    double len = 0;
                    while (r < down) {
                        sum += mat[r][c];
                        r++;
                        len++;
                    }
                    r--;
                    right--;
                    dir = 'l';
                    c--;
                    System.out.printf("%.2f ", sum / len);
                } else if (dir == 'l') {
                    int sum = 0;
                    double len = 0;
                    while (c > left) {
                        sum += mat[r][c];
                        c--;
                        len++;
                    }
                    c++;
                    down--;
                    dir = 'u';
                    r--;
                    System.out.printf("%.2f ", sum / len);
                } else {
                    int sum = 0;
                    double len = 0;
                    while (r > up) {
                        sum += mat[r][c];
                        r--;
                        len++;
                    }
                    r++;
                    left++;
                    dir = 'r';
                    c++;
                    System.out.printf("%.2f ", sum / len);
                }
            }
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new romina().run();
    }
}
