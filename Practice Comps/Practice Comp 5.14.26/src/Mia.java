import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Mia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Mia".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int n = f.nextInt();
            int[][] mat = new int[n][n];
            int[] countPerCol = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = f.nextInt();
                    if(mat[i][j] == 1){
                        countPerCol[j]++;
                    }
                }
            }
            boolean isIdentity=true;
            for (int i = 0; i < n; i++) {
                isIdentity &= mat[i][i] == 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j) continue;
                    if(mat[i][j]==1){
                        isIdentity = false;
                    }
                }
            }
            boolean isValid = true;
            for (int i = 0; i <n ; i++) {
                if(countPerCol[i]!=1) isValid = false;
            }
            System.out.print("Matrix "+times+": ");
            String out = "";
            if(isValid){
                out = "Identity Matrix";
                if(isIdentity){
                    out+=" - No swaps needed";
                }
                else{
                    out+=" - Swaps needed";
                }
            }
            else{
                out = "This is not an Identity Matrix";
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Mia().run();
    }
}
