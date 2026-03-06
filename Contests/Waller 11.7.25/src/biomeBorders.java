import java.util.*;
import java.io.*;
import java.awt.*;

public class biomeBorders{

    char[][] mat;
    char start;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("biomeBorders".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();

        while(times-->0){
            int r = f.nextInt();
            int c = f.nextInt(); f.nextLine();
            mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
            }
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == '.'){
                        continue;
                    }
                    start = mat[i][j];
                    int a = recur(i, j);
                    if(a>0) count++;
                }
            }
            System.out.println(count);

        }
        f.close();
    }

    int recur(int r, int c){
        if(r<0 || r>=mat.length || c<0 || c>=mat[r].length || mat[r][c]!=start) return 0;
        mat[r][c] = '.';
        return 1+recur(r+1,c)+recur(r-1, c)+recur(r, c+1)+recur(r, c-1);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new biomeBorders().run();
    }
}
