import java.util.*;
import java.io.*;
import java.awt.*;

public class Atlantis{
    char[][][] mat;
    int[][][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Atlantis".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abcd = 1; abcd<=times;abcd++){
            System.out.println("Test Case #"+abcd+":");
            int l=f.nextInt(), r=f.nextInt(), c=f.nextInt(), t = f.nextInt(); f.nextLine();
            int sl=-1,sr = -1, sc=-1;
            mat = new char[l][r][c];
            shadow = new int[l][r][c];
            for(int i=0;i<l;i++){
                for(int j=0;j<r;j++){
                    mat[i][j] = f.nextLine().trim().toCharArray();
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                    for (int k = 0; k < c; k++) {
                        if(mat[i][j][k] == 'S'){
                            sl=i;
                            sr=j;
                            sc=k;
                        }
                    }
                }
            }
            dfs(sl, sr, sc, 0);
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        System.out.print((shadow[i][j][k]==Integer.MAX_VALUE?-1:shadow[i][j][k])+" ");
                    }
                    System.out.println();
                }
                System.out.println("-".repeat(10));
            }
            System.out.println();
            while(t-->0){
                int el=f.nextInt(), er=f.nextInt() , ec=f.nextInt();
                int minMoves = shadow[el][er][ec];
                System.out.println(minMoves==Integer.MAX_VALUE?"Swept away by the Riptide.":minMoves);
            }
        }
        f.close();
    }
    void dfs(int l, int r, int c, int moves){
        if(l<0 ||l>=mat.length|| r<0 ||r>=mat[l].length|| c<0
                || c>=mat[l][r].length||shadow[l][r][c]<=moves || mat[l][r][c]=='#'){
            return;
        }
        shadow[l][r][c]=moves;
        char curr = mat[l][r][c];
        if(curr=='.' || curr == 'S'){
            dfs(l-1,r,c,moves+1);
            dfs(l+1,r,c,moves+1);
            dfs(l,r+1,c,moves+1);
            dfs(l,r-1,c,moves+1);
            dfs(l,r,c-1,moves+1);
            dfs(l,r,c+1,moves+1);
        }
        else if(curr=='D'){dfs(l+1,r,c,moves+1);}
        else if(curr=='U'){dfs(l-1,r,c,moves+1);}
        else if(curr=='R'){dfs(l,r,c+1,moves+1);}
        else if(curr=='L'){dfs(l,r,c-1,moves+1);}
        else if(curr=='F'){dfs(l,r+1,c,moves+1);}
        else if(curr=='B'){dfs(l,r-1,c,moves+1);}
        else if (curr=='@'){
            dfs(l-1,r,c,moves+3);
            dfs(l+1,r,c,moves+3);
            dfs(l,r+1,c,moves+3);
            dfs(l,r-1,c,moves+3);
            dfs(l,r,c-1,moves+3);
            dfs(l,r,c+1,moves+3);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Atlantis().run();
    }
}
