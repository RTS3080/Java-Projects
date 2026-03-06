import java.util.*;
import java.io.*;

public class emma{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("emma".toLowerCase()+".dat"));
        int[] sizes = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int size : sizes){
            char[][] mat = new char[size*3][size*3];
            for(char[] chs : mat){
                Arrays.fill(chs, ' ');
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = '*';
                    mat[i+size*2][j] = '*';
                    mat[i+size*2][j+size*2] = '*';
                    mat[i][j+size*2] = '*';
                }
            }
            for (int i = 0; i < size; i++) {
                mat[size + i][size+i] = '*';
                mat[size + i][size*2-i-1] = '*';
            }
            for(char[] chs : mat){
                System.out.println(chs);
            }
            System.out.println("=".repeat(10));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new emma().run();
    }
}
