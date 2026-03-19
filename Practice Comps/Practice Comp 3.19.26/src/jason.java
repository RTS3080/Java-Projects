import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jason{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jason".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r1=f.nextInt(), c1 = f.nextInt(), r2=f.nextInt(), c2 = f.nextInt();
            int[][] a = new int[r1][c1];
            int[][] b = new int[r2][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    a[i][j] = f.nextInt();
                }
            }
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    b[i][j] = f.nextInt();
                }
            }
            if(c1 != r2){
                System.out.println(times+":MATRIX SIZES NOT COMPATIBLE");
                System.out.println("^".repeat(15));
                continue;
            }
            int[][] c = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {

                    int sum = 0;
                    for (int k = 0; k < r2; k++) {
                        sum+=a[i][k] * b[k][j];
                    }
                    c[i][j] = sum;
                }
            }
            System.out.printf("%d:%dx%d\n", times, r1, c2);
            for(int[] arr : c){
                String out = "";
                for(int i : arr) {
                    out+=String.format("%7d", i);
                }
                System.out.println(out);
            }
            System.out.println("^".repeat(15));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jason().run();
    }
}
