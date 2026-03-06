import java.util.*;
import java.io.*;

public class square{
    int[][] memo;
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("square".toLowerCase()+".dat"));
        int times = in.nextInt();
        in.nextLine();
        for (int i = 0; i < times; i++) {
            int m  = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            char[][] mat = new char[m][n];
            memo = new int[m][n];
            for(int[] row : memo){
                Arrays.fill(row, -1);
            }
            for (int j = 0; j < m; j++) {
                mat[j] = in.nextLine().toCharArray();
            }
            int ans =0;
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat[j].length; k++) {
                    if(mat[j][k] == 'x') ans++;
                }
            }
            ans+=recur(0,0, mat)-1;
            System.out.println(Arrays.deepToString(memo));
            System.out.println(ans);

        }
        in.close();
    }
    public int recur(int r, int c, char[][] mat){
        if(r>=mat.length||c>=mat[0].length){
            return 0;
        }
        if(mat[r][c] == '.') return 0;
        if(memo[r][c]!=-1) return memo[r][c];
        int result = recur(r+1, c+1, mat)+recur(r, c+1, mat)+recur(r+1, c, mat);
        if(r+1<mat.length&&c+1<mat[0].length){
            if(mat[r+1][c]=='x' && mat[r][c+1] == 'x' && mat[r+1][c+1]=='x'){
                result+=1;
            }
        }
        return memo[r][c] = result;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new square().run();
    }
}

