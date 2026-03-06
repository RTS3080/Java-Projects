import java.util.*;
import java.io.*;

public class chase{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("chase".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int size = f.nextInt();
            char[][] mat = new char[size][size];
            for (int i = 0; i < size; i++) {
                mat[i] = f.next().toCharArray();
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] == '&') {
                        for (int r = i - 1; r <= i + 1; r++) {
                            for (int c = j - 1; c <= j + 1; c++) {
                                if (r < 0 || c < 0 || r >= size || c >= size) continue;
                                mat[r][c] = '$';
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                System.out.println(mat[i]);
            }
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new chase().run();
    }
}
