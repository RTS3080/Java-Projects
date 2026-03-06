import java.util.*;
import java.io.*;

public class decisions{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("decisions".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r= f.nextInt(); int c= f.nextInt(); f.nextLine();
            mat = new char[r][c];
            shadow = new int[r][c];
            int startr = 0, startc = 0;
            ArrayList<int[]> warehouses = new ArrayList<>();
            for(int i=0;i<r;i++){
                char[] ln = f.nextLine().toCharArray();
                for(int j=0;j<c;j++){
                    mat[i][j] = ln[j];
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j]== 'R'){
                        startr = i;
                        startc = j;
                    }
                    else if(mat[i][j]== 'W'){
                        warehouses.add(new int[]{i,j});
                    }
                }
            }
            recur(startr, startc, 0);
            int min = Integer.MAX_VALUE;
            int minR = -1;
            int minC = -1;
            for(int[] i : warehouses){
                if(shadow[i[0]][i[1]]<min){
                    min = shadow[i[0]][i[1]];
                    minR = i[0];
                    minC = i[1];
                }
            }
            if(min == Integer.MAX_VALUE){
                System.out.println("Send a helicopter");
            }
            else{
                System.out.println(minR+" "+minC);
            }
        }
        f.close();
    }
    public void recur(int r, int c, int moves){
        if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == '#' ||shadow[r][c] <= moves){
            return;
        }
        shadow[r][c] = moves;
        moves++;
        recur(r+1, c, moves);
        recur(r-1, c, moves);
        recur(r, c+1, moves);
        recur(r, c-1, moves);

    }



    public static void main(String[] args) throws FileNotFoundException{
        new decisions().run();
    }
}
