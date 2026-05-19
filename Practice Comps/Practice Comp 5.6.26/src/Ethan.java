import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Ethan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ethan".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int dim = f.nextInt();
            int[][] mat = new int[dim][dim];
            int r = -1;
            int c = -1;
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    mat[i][j] = f.nextInt();
                    if(mat[i][j] == 1){
                        r = i;
                        c = j;
                    }
                }
            }
            double dist = 0;
            loop:
            for (int i = 2; i <= dim * dim; i++) {
                for (int j = 0; j < dim; j++) {
                    for (int k = 0; k < dim; k++) {
                        if(mat[j][k] == i){
                            dist += hypot(r - j, c - k);
                            r = j;
                            c = k;
                            continue loop;
                        }
                    }
                }
            }
            System.out.printf("Case %d distance: %.4f\n",times,dist);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ethan().run();
    }
}
