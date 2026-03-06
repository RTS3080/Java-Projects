import java.util.*;
import java.io.*;
import java.awt.*;

public class doors{
    char[][] mat;
    int[][][] shadow;
    String doors;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("doors".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt(); int max = f.nextInt();
            f.nextLine();
            mat = new char[rows][cols];
            doors = "";
            int keyCount = 0;
            int startR = -1, startC = -1, endR = -1, endC = -1;
            for (int i = 0; i < rows; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    if(Character.isLowerCase(mat[i][j])){
                        doors+=Character.toUpperCase(mat[i][j]);
                        mat[i][j] = (char)keyCount;
                        keyCount++;
                    }

                    if (mat[i][j] == ']') {
                        startR = i;
                        startC = j;
                    }
                    if (mat[i][j] == '[') {
                        endR = i;
                        endC = j;
                    }
                }
            }
            shadow = new int[1<<keyCount][rows][cols];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }

            recur(0, startR, startC, 0, "");
            int bmoves = Integer.MAX_VALUE;
            for (int i = 0; i < shadow.length; i++) {
                bmoves = Math.min(bmoves, shadow[i][endR][endC]);
            }
            System.out.println(bmoves<= max ? "Amazeing Job. Escaped in "+bmoves+" steps." : "Mother knows best.");
        }
        f.close();
    }

    public void recur(int l, int r, int c, int moves, String keys){
        if(l<0 || l>= shadow.length || r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#'
                || moves>= shadow[l][r][c]){
            return;
        }
        if(Character.isUpperCase(mat[r][c]) && !keys.contains(mat[r][c]+"")){
            return;
        }
        shadow[l][r][c] = moves;
        if(mat[r][c] <= 25){
            int ch = mat[r][c];
            keys += doors.charAt(ch);
            l|=1<<ch;
            mat[r][c] = '.';
            recur(l,r,c,moves,keys);
            mat[r][c] = (char)ch;
        }
        else {
            recur(l, r - 1, c, moves + 1, keys);
            recur(l, r, c - 1, moves + 1, keys);
            recur(l, r, c + 1, moves + 1, keys);
        }

    }

    public static void main(String[] args) throws FileNotFoundException{
        new doors().run();
    }
}
