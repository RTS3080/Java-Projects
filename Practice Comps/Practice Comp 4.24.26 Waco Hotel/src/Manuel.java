import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Manuel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Manuel".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int size = f.nextInt();
            double[][] mat = new double[3][4];
            for (int i = 0; i < size; i++) {
                Arrays.fill(mat[i], 0);
                String[] ln = f.next().split("[a-z=]+");
                if(ln.length == 3){
                    for (int j = 0; j < 2; j++) {
                        mat[i][j] = Double.parseDouble(ln[j]);
                    }
                    mat[i][3] = Double.parseDouble(ln[2]);
                }
            }
            int pivot = 0;
            if(mat[0][0] == 0){
                if(mat[0][1] != 0){
                    pivot=1;
                }
                else{
                    pivot = 2;
                }
            }
            for (int i = 1; i < 3; i++) {

                double change = (mat[i][pivot] == 0 ? 1 : mat[0][pivot]/mat[i][pivot]);
                for (int j = 0; j < 4; j++) {
                    mat[i][j] *=change;
                    mat[i][j]-=mat[0][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Arrays.toString(mat[i]));
            }
            System.out.println();

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Manuel().run();
    }
}
