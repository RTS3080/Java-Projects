import java.util.*;
import java.io.*;
import java.awt.*;

public class rounds{
    char[][] mat;
    int[][][] shadow;
    int[] tableCosts;
    String visits;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rounds".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r= f.nextInt(), c= f.nextInt(), e= f.nextInt();
            f.nextLine();
            visits = f.nextLine().trim();
            String[] toVisit = visits.split(" ");
            tableCosts = new int[e];
            String lns = "";
            for (int i = 0; i < e; i++) {
                lns+=f.nextLine().trim()+",";
            }
            String[] tables = lns.split("\\|");
            System.out.println(Arrays.toString(tables));
            for (int i = 0; i < e; i++) {
                int cost = 0;
                for(String s : tables[i].split(",")){
                    if(s.isEmpty()) continue;
                    cost+=Integer.parseInt(s);
                }
                tableCosts[i] = cost;
            }
            System.out.println(Arrays.toString(tableCosts));
            int sr = -1, sc = -1;
            mat = new char[r][c];
            shadow = new int[1<<toVisit.length-1][r][c];
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < r; j++) {
                    Arrays.fill(shadow[i][j], Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                }
            }
            recur(0, sr, sc, 0);
            int t = shadow[shadow.length-1][sr][sc];
            System.out.printf("%.2f\n", t/60.);
        }
        f.close();
    }

    void recur(int l, int r, int c, int moves){
        if(l<0 || l>=shadow.length || r<0 || r>=shadow[0].length || c<0 ||
                c>=shadow[r].length || mat[r][c] == '#'|| shadow[l][r][c] <=moves){
            return;
        }
        shadow[l][r][c] = moves;
        if((mat[r][c]+"").matches("[A-Z]")){
            int ind = visits.indexOf((mat[r][c]+""));
            l |= 1 << ind;
        }
        if(Character.isDigit(mat[r][c])){
            moves+=tableCosts[mat[r][c]-'0'];
        }
        if(mat[r][c] == '$'){
            moves+=35;
        }
        moves+=10;
        recur(l, r-1, c, moves);
        recur(l, r+1, c, moves);
        recur(l, r, c-1, moves);
        recur(l, r, c+1, moves);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new rounds().run();
    }
}
