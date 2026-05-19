import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class shirley{
    class blob{
        int sum;
        int plots;
        public blob(int sum, int plots){
            this.sum = sum;
            this.plots = plots;
        }
        public String toString(){
            return sum + " " + plots;
        }
    }
    int[][] mat;
    ArrayList<blob> blobs;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shirley".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            mat  = new int[r][c];
            blobs = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j <c; j++) {
                    blob b = dfs(i, j);
//                    System.out.println(b);
                    if(b.plots>1){
                        blobs.add(b);
                    }
                }
            }
            Collections.sort(blobs, (a, b) -> b.sum-a.sum);
            System.out.println("Case #"+times +":");
            for (int i = 0; i < 3 && i < blobs.size(); i++) {
                System.out.printf("%d %.1f\n", blobs.get(i).sum, 100*blobs.get(i).plots/ ((double) r*c));
            }
            if(blobs.size()<3){
                System.out.print("NONE\n".repeat(3-blobs.size()));
            }
            System.out.println("^".repeat(12));
        }
        f.close();
    }
    blob dfs(int r, int c){
        if(r < 0 || c < 0 || r>=mat.length || c>=mat[0].length || mat[r][c] <250){
            return new blob(0, 0);
        }
        blob b = new blob(mat[r][c], 1);
        mat[r][c] = 0;
        blob[] dirs = new blob[4];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            dirs[i] = dfs(r+dx[i], c+dy[i]);
        }
//        System.out.println(Arrays.toString(dirs));
        for (int i = 0; i < 4; i++) {
            b.sum+=dirs[i].sum;
            b.plots+=dirs[i].plots;
        }
        return b;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new shirley().run();
    }
}
