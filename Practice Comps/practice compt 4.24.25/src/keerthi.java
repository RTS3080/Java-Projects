import java.util.*;
import java.io.*;

public class keerthi{
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("keerthi".toLowerCase()+".dat"));
        int times = in.nextInt();
        in.nextLine();

        for (int i = 0; i < times; i++) {
            char[][] mat = new char[10][10];
            for (int j = 0; j < 10; j++) {
                mat[j] = in.nextLine().toCharArray();
            }
            shadow = new int[10][10];
            int[] mr = {0,1,0,-1};
            int[] mc = {1,0,-1,0};
            int r = 0;
            int c = 0;
            int dir = 0;
            int border = 36;
            for (int j = 0; j < border; j++) {
                if(mat[r][c] == '#') {
                    recur(r, c, mat);
                }
                int nr = r+mr[dir%4];
                int nc = c+mc[dir%4];
                while(nr<0 || nc<0 || nr>=10 || nc>=10){
                    dir++;
                    nr = r+mr[dir%4];
                    nc = c+mc[dir%4];
                }
                r = nr;
                c = nc;
            }
//            System.out.println(Arrays.deepToString(shadow));
            int cnt = 0;
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat[j].length; k++) {
                    if(shadow[j][k]==0 && mat[j][k] == '#'){
                        recur(j, k, mat);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            in.nextLine();

        }
        in.close();
    }
    public void recur(int r, int c, char[][] mat){
        if(r>=0 && c>=0 && r<mat.length && c<mat[r].length){
            if(shadow[r][c]==0 && mat[r][c] == '#'){
                shadow[r][c] = 1;
                recur(r+1,c,mat);
                recur(r,c+1,mat);
                recur(r-1, c, mat);
                recur(r,c-1,mat);
            }
            else{
                return;
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new keerthi().run();
    }
}

