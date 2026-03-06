import java.util.*;
import java.io.*;
import java.awt.*;

public class drillin{
    char[][] mat;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("drillin".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            mat = new char[10][10];
            for (int i = 0; i < 10; i++) {
                String ln = f.next().trim();
                mat[i] = ln.toCharArray();
            }
            int min = 101;
            int max = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int a= recur(i,j);
                    max = Math.max(max,a);
                    if(a>0){
                        min = Math.min(min,a);
                    }
                }
            }
            if(max == 0){
                System.out.println("I have been drilling holes in the earth for 30 years. And I have never, NEVER missed a depth that I have aimed for.");
            }
            else{
                System.out.printf("[%d, %d]\n", min, max);
            }
        }
        f.close();
    }
    int recur(int r, int c){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] != 'O'){
            return 0;
        }
        mat[r][c] = 'X';
        return 1+ recur(r+1, c) + recur(r, c+1) + recur(r-1, c) + recur(r, c-1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new drillin().run();
    }
}
