import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class gnome{
    char[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gnome".toLowerCase()+".dat"));
        int times=f.nextInt();
        while(times-->0){
            int sz = f.nextInt(); f.nextLine();
            mat = new char[sz][];
            for (int i = 0; i < sz; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
            }
            int count = 0;
            for(int i = sz-1; i>=0; i--){
                for(int j =0; j< mat[i].length; j++){
                    if(mat[i][j] == '.') continue;
                    int a = dfs(i, j);
                    if(a > 0){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        f.close();
    }
    int dfs(int r, int c){
        if(r <0 || r >= mat.length || c <0 || c>=mat[r].length || mat[r][c] == '.'){
            return 0;
        }
        mat[r][c] = '.';
        return dfs(r-1, c) + dfs(r, c+1) + dfs(r, c-1) + 1;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new gnome().run();
    }
}
