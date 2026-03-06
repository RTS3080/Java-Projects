import java.util.*;
import java.io.*;

public class fixing{
    char[][] mat;
    int[][] shadow;
    int bmoves;
    ArrayList<Character> fixed;

    public void run() throws FileNotFoundException {
        Scanner f= new Scanner(new File("fixing".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r=f.nextInt();f.nextLine();
//            int c=f.nextInt();
            int startR=0,startC=0;
            fixed=new ArrayList<>();
            mat=new char[r][r];
            shadow=new int[r][r];
            for (int i = 0; i < r; i++) {
                char[] ch=f.nextLine().toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                mat[i] = ch;
                for (int j = 0; j < r; j++) {
                    if(mat[i][j]=='J'){
                        startR=i;
                        startC=j;
                    }
                }
            }
            bmoves=Integer.MAX_VALUE;
            recur(startR,startC,0);
            System.out.println(bmoves);
        }
        f.close();
    }
    public static void main(String[] args) throws FileNotFoundException{
        new fixing().run();
    }
    public void recur(int r, int c, int moves){
        if(r>-1 && c>-1 && r<mat.length && c<mat[r].length && mat[r][c]!='#' && shadow[r][c]>moves){
            shadow[r][c]=moves;
            if(mat[r][c]>='A' && mat[r][c]<='Z'){
                fixed.add(mat[r][c]);
                mat[r][c] = '.';
                moves+=10;
                System.out.println("found "+fixed.get(fixed.size()-1));
                for (int i = 0; i < shadow.length; i++) {
                    Arrays.fill(shadow[i],Integer.MAX_VALUE);
                }
                if(fixed.size()==5){
                    bmoves=moves;
                    return;
                }
            }

            recur(r+1,c,moves+1);
            recur(r-1,c,moves+1);
            recur(r,c+1,moves+1);
            recur(r,c-1,moves+1);
        }
    }
}