import java.util.*;
import java.io.*;

public class Prachi{
    char[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Prachi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt();
            int c = f.nextInt();
            int sr = f.nextInt();
            int sc = f.nextInt();
            f.nextLine();
            mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            recur(sr,sc);
            for (int i = 0; i < r; i++) {
                System.out.println(mat[i]);
            }
        }
        f.close();
    }

    public void recur(int r, int c){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || mat[r][c] =='#' || mat[r][c] =='$'){
            return;
        }
        mat[r][c] = '$';
        recur(r+1, c);
        recur(r-1, c);
        recur(r, c+1);
        recur(r, c-1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Prachi().run();
    }
}
