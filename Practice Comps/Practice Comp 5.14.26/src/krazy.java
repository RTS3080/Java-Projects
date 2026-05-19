import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class krazy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("krazy".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int R = f.nextInt();
            int C = f.nextInt();

            char[][] mat = new char[R][C];
            char[] str = "Krazy Glue!".toCharArray();

            int l = 0;
            int r = C - 1;
            int t = 0;
            int b = R - 1;

            int idx = 0;

            while (l <= r && t <= b) {
                for (int i = l; i <= r; i++) {
                    if (mat[t][i] != 0) break;
                    mat[t][i] = str[idx];
                    idx = (idx + 1) % str.length;
                }

                t++;

                for (int i = t; i <= b; i++) {
                    if (mat[i][r] != 0) break;
                    mat[i][r] = str[idx];
                    idx = (idx + 1) % str.length;
                }

                r--;

                for (int i = r; i >= l; i--) {
                    if (mat[b][i] != 0) break;
                    mat[b][i] = str[idx];
                    idx = (idx + 1) % str.length;
                }

                b--;

                for (int i = b; i >= t; i--) {
                    if (mat[i][l] != 0) break;
                    mat[i][l] = str[idx];
                    idx = (idx + 1) % str.length;
                }

                l++;
            }

            for (char[] row : mat) {
                System.out.println(row);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new krazy().run();
    }
}
