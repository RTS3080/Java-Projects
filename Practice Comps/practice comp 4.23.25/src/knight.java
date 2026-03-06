import java.awt.*;
import java.util.*;
import java.io.*;

public class knight{
    int[][] vis;
    ArrayList<Point> pts;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("knight".toLowerCase()+".dat"));
        int n = f.nextInt(); f.nextLine();
        vis = new int[n][n];
        for (int i = 0; i < vis.length; i++) {
            Arrays.fill(vis[i],0);
        }
        pts= new ArrayList<>();
        while(f.hasNext()){
            pts.add(new Point(f.nextInt(), f.nextInt()));
        }
        recur(0,0, 0);
        int max = 0;
        for(int i = 0; i < vis.length; i++){
            for(int j = 0; j < vis.length; j++){
                if(vis[i][j] > max){
                    max = Math.max(vis[i][j], max);
                }
            }
        }
//        System.out.println(pts);
        System.out.println(max);
//        for(int i = 0; i < vis.length; i++){
//            for(int j = 0; j < vis.length; j++){
//                System.out.print((vis[7-i][j]) + " ");
//            }
//            System.out.println();
//        }

        f.close();
    }
    void recur(int r, int c, int moves){
        if(r<0 || r>=vis.length || c<0 || c>=vis.length) return;
        if(pts.contains(new Point(c,r))) {
            moves += 1;
        }
        vis[r][c] = Math.max(moves, vis[r][c]);
        recur(r + 2, c + 1 ,moves);
        recur(r - 2, c + 1 ,moves);
        recur(r + 1, c + 2 ,moves);
        recur(r - 1, c + 2 ,moves);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new knight().run();
    }
}
