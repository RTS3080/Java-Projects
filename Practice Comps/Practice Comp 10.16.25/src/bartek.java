import java.util.*;
import java.io.*;
import java.awt.*;

public class bartek{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bartek".toLowerCase()+".dat"));
        while(f.hasNext()){
            int n = f.nextInt();
            int size = n*3-2;
            char[][] mat  = new char[size][size];
            for (int i = 0; i < size; i++) {
                Arrays.fill(mat[i], ' ');
            }
            for (int i = 0; i < size/2; i++) {
                for (int j = 0; j < size/2; j++) {
                    if(i+j==n-1){
                        mat[i][j] = '*';
                        mat[i][size-1-j] = '*';
                        mat[size-1-i][j] = '*';
                        mat[size-1-j][size-1-i] = '*';
                    }
                }
            }

            for (int i = n-1; i < size-n+1; i++) {
                mat[0][i] = '*';
                mat[size-1][i] = '*';
                mat[i][0] = '*';
                mat[i][size-1] = '*';
            }
            for (int i = 0; i < size; i++) {
                String s = "";
                for(char c : mat[i]){
                    s+=c;
                }
                System.out.println(s.substring(0, s.lastIndexOf('*')+1));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bartek().run();
    }
}
