import java.util.*;
import java.io.*;
import java.awt.*;

public class Louetta{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Louetta".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt();
            int c = f.nextInt();
            int[][] mat = new int[r][c];
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    mat[i][j]=f.nextInt();
                }
            }
            int[] sums = new int[r + c - 1];
            int indR = 0;
            int indC = c - 1;
            int count = 0;
            while(indC>=0){
                sums[count++] = addDiag(indR, indC, mat);
                indC--;
            }
            indC = 0;
            indR = 1;
            while(indR < mat.length){
                sums[count++] = addDiag(indR, indC, mat);
                indR++;
            }
            String s = "";
            for(int i : sums){
                s+=i+" ";
            }
            System.out.println(s.trim());
            System.out.println("-".repeat(10));
        }
        f.close();
    }

    int addDiag(int r, int c, int[][] mat){
        if(r >= mat.length || c >= mat[0].length){
            return 0;
        }
        return mat[r][c] + addDiag(r+1, c+1, mat);

    }

    public static void main(String[] args) throws FileNotFoundException{
        new Louetta().run();
    }
}
