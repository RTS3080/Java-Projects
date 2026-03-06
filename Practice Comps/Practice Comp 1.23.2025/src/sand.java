import java.util.*;
import java.io.*;

public class sand{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sand".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int size = f.nextInt();
            char[][] mat = new char[size][size];
            for (int i = 0; i < size; i++) {
                Arrays.fill(mat[i], ' ');
                for (int j = 0; j <= i; j++) {
                    mat[i][j] = '$';
                }
            }

            for(char[] chs: mat){
                System.out.println(chs);
            }
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sand().run();
    }
}
