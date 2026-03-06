import java.util.*;
import java.io.*;
public class hawaii{

    int[][] mat;
    int[][] shadow;
    boolean[][] natives;
    int bcost;
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("hawaii".toLowerCase()+".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(); f.nextLine();
        while(times-->0){
          int size = f.nextInt(); f.nextLine();
          mat = new int[size][size];
          shadow = new int[size][size];
          natives = new boolean[size][size];
          bcost = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                String[] ln = f.nextLine().split(" ");
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                for (int j = 0; j < size; j++) {
                    mat[i][j] = Integer.parseInt(ln[j]);
                    if(i%2==0){
                        if(j%2 == 0) natives[i][j] =true;
                    }
                    else if (j%2==1) natives[i][j] = true;

                }
            }
//            System.out.println(Arrays.deepToString(mat));
            mat[0][0] = 0;
            recur(0,0,0);
            System.out.println(bcost);
        }
        
    }

    void recur(int r, int c, int moves){
        if(r<0 || c<0  || r>=mat.length || c>= mat.length || shadow[r][c] <=moves){
            return;
        }
        shadow[r][c] = moves;

        if(r==mat.length-1 && c==mat.length-1){
            bcost = Math.min(bcost,moves+mat[r][c]);
        }
        recur(r+1,c,moves+mat[r][c]);
        recur(r,c+1,moves+mat[r][c]);

        if(!natives[r][c]){
            recur(r,c-1,moves+mat[r][c]);
            recur(r-1,c,moves+mat[r][c]);
        }

    }

    public static void main(String[] args) throws FileNotFoundException{
        new hawaii().run();
    }
}