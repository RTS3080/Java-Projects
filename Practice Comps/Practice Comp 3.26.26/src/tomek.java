import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class tomek{
char[][] mat;
boolean outside;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tomek".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
            }
            ArrayList<Integer> sizes = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    outside = false;
                    if(mat[i][j] == '.'){
                        int a = dfs(i, j);
                        if(a>0 && outside == false){
                            sizes.add(a);
                        }
                    }
                }
            }
            System.out.println("Case #"+times +": "+sizes.size());
            Collections.sort(sizes, Collections.reverseOrder());
            if(sizes.size() == 0){
                System.out.println("NONE");
            }
            else {
                String o = "";
                for (int i : sizes) {
                    o += i + " ";
                }
                System.out.println(o.trim());
            }
        }
        f.close();
    }

    int dfs(int r, int c){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length){
            outside = true;
            return 0;
        }
        if(mat[r][c] == 'W'){
            return 0;
        }
        mat[r][c] = 'W';
        return 1 + dfs(r-1, c) + dfs(r+1, c)+dfs(r, c-1)+dfs(r, c+1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new tomek().run();
    }
}
