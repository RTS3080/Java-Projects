import java.util.*;
import java.io.*;

public class rashi{
    double[][][] mat;
    int size;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rashi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abc = 1; abc <=times;abc++) {
            int[] dims = Arrays.stream(f.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            mat = new double[dims[0]][dims[1]][dims[2]];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    mat[i][j] = Arrays.stream(f.nextLine().split(",")).mapToDouble(Double::parseDouble).toArray();
                }
            }
            ArrayList<Double> vals = new ArrayList<>();
            for (int i = 0; i < dims[0]; i++) {
                for (int j = 0; j < dims[1]; j++) {
                    for (int k = 0; k < dims[2]; k++) {
                        if (mat[i][j][k] > 0) {
                            size = 0;
                            double a = recur(i, j, k);
                            if(size>=2){
                                vals.add(a);
                            }
                        }
                    }
                }
            }
            Collections.sort(vals, Collections.reverseOrder());
            System.out.println("TEST CASE #"+abc+":");
            if(vals.size()==0){
                System.out.println("NO CLUSTERS FOUND");
            }
            for(double d : vals){
                System.out.printf("%.2f\n", d);
            }
            System.out.println("=".repeat(12));
        }

        f.close();
    }
    double recur(int l, int r, int c){
        if(l < 0 || l >= mat.length || r < 0 || r >= mat[l].length || c < 0 || c >= mat[l][r].length ||
        mat[l][r][c] == 0){
            return 0;
        }
        double a = mat[l][r][c];
        mat[l][r][c] = 0;
        size++;
        return a +
                recur(l-1, r, c) +
                recur(l+1, r, c) +
                recur(l, r+1, c) +
                recur(l, r-1, c) +
                recur(l, r, c-1) +
                recur(l, r, c+1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new rashi().run();
    }
}
