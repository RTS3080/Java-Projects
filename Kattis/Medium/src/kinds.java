import java.util.*;
import java.io.*;

public class kinds{
    char[][] mat;
    int[][] shadow;
    int r2;
    int c2;
    boolean found;
    char lang = '1';
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int rows = f.nextInt();
        int cols = f.nextInt();
        mat = new char[rows][cols];
        shadow = new int[rows][cols];

        for (int i = 0; i < mat.length; i++) {
            mat[i] = f.next().toCharArray();
            for(int j = 0; j < mat[i].length; j++){
                shadow[i][j] = Integer.MAX_VALUE;
            }
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r1 = f.nextInt()-1;
            int c1 = f.nextInt()-1;
            r2 = f.nextInt()-1;
            c2 = f.nextInt()-1;
//            System.out.println(r1+" "+c1+" : "+r2+" "+c2);

            boolean binary = false;
            boolean decimal = false;
            lang = '1';
            recur(r1,c1,0);
            binary = found;
            found=false;
            for(int j = 0; j < shadow.length; j++){
                for(int k = 0; k < shadow[j].length; k++){
                    shadow[j][k] = Integer.MAX_VALUE;
                }
            }
            lang = '0';
            recur(r1,c1,0);
            decimal = found;
//            System.out.println("binary: "+binary+" decimal: "+decimal);
            if(binary)
                System.out.println("binary");
            else if(decimal)
                System.out.println("decimal");
            else
                System.out.println("neither");
            found = false;
        }
        f.close();
    }
    void recur(int r, int c,int moves){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || moves >= shadow[r][c] || mat[r][c]==lang){
//            System.out.println("broken "+r+" "+c+" "+shadow[r][c]+" "+mat[r][c]);
            return;
        }
        if(found) return;
        shadow[r][c] = moves;
        if(r==r2 && c==c2){
            found = true;
            return;
        }
        recur(r+1, c, moves+1);
        recur(r-1, c, moves+1);
        recur(r, c+1, moves+1);
        recur(r, c-1, moves+1);
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new kinds().run();
    }
}
