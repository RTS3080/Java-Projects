import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sergey{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sergey".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int rot = f.nextInt() / 90 % 4;

            char[][] mat = new char[N][N];

            for (int i = 0; i < N; i++) {
                mat[i] = f.next().toCharArray();
            }

            for (int i = 0; i < rot; i++) {
                char[][] copy = new char[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        copy[c][N - r - 1] = mat[r][c];
                    }
                }

                mat = copy;
            }

            for (int i = 0; i < N; i++) {
                System.out.println(mat[i]);
            }

            System.out.println("DONE");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sergey().run();
    }
}
