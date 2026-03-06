import java.util.*;
import java.io.*;

public class railroad{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("railroad".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            int numPlat = f.nextInt();

            int[] rowInc = new int[rows+1];
            int[] colInc = new int[cols+1];


            for (int i = 0; i < numPlat; i++){
                int sRow = f.nextInt();
                int sCol = f.nextInt();
                int width = f.nextInt();
                int length = f.nextInt();

                if (sRow < 0 || sRow >= rows || sCol < 0 || sCol >= cols) continue;
                int eRow = Math.min(rows, sRow+width);
                int eCol = Math.min(cols, sCol+length);

                rowInc[sRow]++;
                rowInc[eRow]--;

                colInc[sCol]++;
                colInc[eCol]--;
            }

            int result = 0;
            int temp = 0;
            for (int i = 0; i < rows; i++){
                temp += rowInc[i];
                if (temp == 0) result++;
            }
            temp = 0;
            for (int i = 0; i < cols; i++){
                temp += colInc[i];
                if (temp == 0) result++;
            }

            System.out.println(result);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new railroad().run();
    }
}
