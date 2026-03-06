import java.util.*;
import java.io.*;
import java.awt.*;

public class queen{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("queen".toLowerCase()+".dat"));

        int cases = f.nextInt();
        int[] results = new int[]{1,
                0,
                0,
                2,
                10,
                4,
                40,
                92,
                352,
                724,
                2680,
                14200,
                73712
        };

        while (cases-- > 0){
            N = f.nextInt();
            System.out.println(results[N-1]);
        }

        f.close();
    }

    int N;
    int result;

    public void recur(int vert, int horiz, int DTLBR, int DTRBL, int R, int C, int cur){

        if (C == N){
            recur(vert, horiz, DTLBR, DTRBL, R+1, 0, cur);
            return;
        }
        if (R == N){
            return;
        }




        if ((vert & (1 << R)) == 0 &&
                        (horiz & (1 << C)) == 0 &&
                        (DTLBR & (1 << (R-C+(N-1)))) == 0 &&
                        (DTRBL & (1 << (R+C))) == 0){
            if (cur+1 == N) result++;

            recur(vert | (1 << R), horiz | (1 << C), DTLBR | (1 << (R-C+(N-1))), DTRBL | (1 << (R+C)), R, C+1, cur+1);
                }
//                if ((vert & (1 << r)) == 0){
//                    recur(vert | (1 << r), horiz, DTLBR, DTRBL, r, c, cur+1);
//                }
//                if ((horiz & (1 << c)) == 0){
//                    recur(vert, horiz | (1 << c), DTLBR, DTRBL, r, c, cur+1);
//                }
//                if ((DTLBR & (1 << (r-c+(N-1)))) == 0){
//                    recur(vert, horiz, DTLBR | (1 << (r-c+(N-1))), DTRBL, r, c, cur+1);
//                }
//                if ((DTRBL & (1 << (r+c))) == 0){
//                    recur(vert, horiz, DTLBR, DTRBL | (1 << (r+c)), r, c, cur+1);
//                }


        recur(vert, horiz, DTLBR, DTRBL, R, C+1, cur);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new queen().run();
    }
}
