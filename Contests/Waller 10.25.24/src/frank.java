import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class frank{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    ArrayList<Integer> prevs;
    char[][] tracer;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("frankenstein".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = rows;
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            bmoves=Integer.MAX_VALUE;
            prevs = new ArrayList<>();
            tracer = new char[rows][cols];
            int startR = -1;
            int startC = -1;
            int endR = -1;
            int endC = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(tracer[i],'#');
                for (int j = 0; j < cols; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if (mat[i][j] == '@') {
                        startR = i;
                        startC = j;
                    }
                    if (mat[i][j] == '!') {
                        endR = i;
                        endC = j;
                    }
                }
            }

            recur(startR,startC,0);
//            System.out.println(bmoves!= Integer.MAX_VALUE ? "MADE IT HOMEY" : "NO LUCK");
            tracePath(startR,startC,bmoves);
            for(char[] chars : tracer) {
                for (char c : chars)
                    System.out.print(c);
                System.out.println();
            }
            System.out.println();
        }
        f.close();
    }

    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
                || moves>=shadow[r][c]){
            return;
        }
        shadow[r][c] = moves;
        if(mat[r][c]=='E'){
            bmoves = moves;
            return;
        }

        recur(r+1,c,moves+1);
        recur(r-1,c,moves+1);
        recur(r,c-1,moves+1);
        recur(r,c+1,moves+1);
    }


    public void tracePath(int r, int c,int prev){
            if(r<0 || c<0 || r>mat.length-1 || c>mat[0].length-1 || prev-1 !=shadow[r][c] || prevs.contains(prev)){
                return;
            }
            prevs.add(prev);
            int here = shadow[r][c];
            shadow[r][c] = -1;
            mat[r][c] = '*';
            tracePath(r+1,c,here);
            tracePath(r-1,c,here);
            tracePath(r,c-1,here);
            tracePath(r,c+1,here);
        }

    public static void main(String[] args) throws FileNotFoundException{
        new frank().run();
    }
}
