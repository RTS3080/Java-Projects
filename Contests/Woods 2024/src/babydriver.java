import java.util.*;
import java.io.*;

public class babydriver {

    char[][] mat;
    int[][] shd;
    int[][] p;
    boolean solved;

    public static void main(String[] args) throws Exception {
        new babydriver().run();
    }

    public void run() throws Exception {

        Scanner in = new Scanner(new File("babydriver.dat"));
        int cases = in.nextInt(); in.nextLine();

        for (int yz = 0; yz < cases; yz++) {

            int r = in.nextInt(); int c = in.nextInt(); int points = in.nextInt(); in.nextLine();

            mat = new char[r][c];
            shd = new int[r][c];
            p = new int[r][c];

            ArrayList<int[]> o = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                Arrays.fill(p[i],Integer.MAX_VALUE);
                mat[i]=in.nextLine().trim().toCharArray();

                for (int j = 0; j < mat[i].length; j++) {
                    if(mat[i][j]=='P'){
                        o.add(new int[]{i,j});
                    }
                }
            }

            for (int j = 0; j < o.size(); j++) {
                polstep(o.get(j)[0],o.get(j)[1],0);
            }

            for (int z = 0; z < points; z++) {
                solved = false;
                int a = in.nextInt(); int b = in.nextInt(); in.nextLine();

                for (int i = 0; i < r; i++) {
                    Arrays.fill(shd[i],Integer.MAX_VALUE);
                }

                recur(a,b,0);

                System.out.println(solved ? "We're gonna make it out!" :  "We're a little cooked.");
            }

            if(yz<cases-1) System.out.println();
        }


    }

    public void recur(int r, int c, int step){
        if(r<0 || c<0 || r>=mat.length || c>= mat[0].length || mat[r][c]=='#' || mat[r][c]=='P' || step>=shd[r][c] || step>=p[r][c]) return;

        if(mat[r][c]=='E'){
            solved = true;
            return;
        }

        shd[r][c] = step;
        recur(r+1, c,step+1);
        recur(r-1, c,step+1);
        recur(r, c+1,step+1);
        recur(r, c-1,step+1);
    }

    public void polstep(int r, int c, int step){
        if(r<0 || c<0 || r>=mat.length || c>= mat[0].length || mat[r][c]=='#' || step >=p[r][c]) return;

        p[r][c] = step;
        polstep(r+1, c,step+1);
        polstep(r-1, c,step+1);
        polstep(r, c+1,step+1);
        polstep(r, c-1,step+1);

    }
}