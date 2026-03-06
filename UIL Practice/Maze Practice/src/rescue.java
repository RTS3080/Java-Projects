import java.util.*;
import java.io.*;

public class rescue{

    char[][][] mat;
    int[][][] shadow;
    int bmoves;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rescue".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abcd = 1;abcd <= times;abcd++){
            int rows = f.nextInt(); int cols = f.nextInt(); int levs = f.nextInt();
            f.nextLine();
            mat = new char[levs][rows][cols];
            shadow = new int[levs][rows][cols];
            bmoves = Integer.MAX_VALUE;
            int startL = 0;
            int startR = 0;
            int startC = 0;
            int endL = 0;
            int endR = 0;
            int endC = 0;
            for(int x = 0; x<levs; x++) {
                for (int i = 0; i < rows; i++) {
                    mat[x][i] = f.nextLine().toCharArray();

                    for (int j = 0; j < cols; j++) {
                        shadow[x][i][j] = Integer.MAX_VALUE;
                        if (mat[x][i][j] == 'S') {
                            startL = x;
                            startR = i;
                            startC = j;
                        }
                        if(mat[x][i][j] == 'E') {
                            endL = x;
                            endR = i;
                            endC = j;
                        }
                    }
                }
            }

            recur(startL,startR,startC,0);
            System.out.println("Rescue #"+abcd+": "+(bmoves!=Integer.MAX_VALUE?bmoves : "NO"));



        }
        f.close();
    }

    public void recur(int l,int r, int c, int moves){
        if(r<0 || c<0 || l<0 || r>mat[0].length-1 || c>mat[0][0].length-1 || l>mat.length-1|| moves>=shadow[l][r][c] ||
                mat[l][r][c] == '#' || bmoves!=Integer.MAX_VALUE){
            return;
        }
        shadow[l][r][c] = moves;
        if(mat[l][r][c] == 'E'){
            bmoves = moves;
            return;
        }
        recur(l,r+1,c,moves+1);
        recur(l,r-1,c,moves+1);
        recur(l,r,c+1,moves+1);
        recur(l,r,c-1,moves+1);
        recur(l+1,r,c,moves+1);
        recur(l-1,r,c,moves+1);

    }


    public static void main(String[] args) throws FileNotFoundException{
        new rescue().run();
    }
}
