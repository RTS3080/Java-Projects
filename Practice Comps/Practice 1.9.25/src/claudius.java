import java.util.*;
import java.io.*;

public class claudius{

    char[][] mat;
    int [][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("claudius".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            int time = f.nextInt(); f.nextLine();
            int sr = -1, sc = -1, er = -1, ec = -1;
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            int bmoves = Integer.MAX_VALUE;
            ArrayList<int[]> bears = new ArrayList();
            ArrayList<int[]> alligators = new ArrayList();

            for (int i = 0; i < rows; i++) {
                String[] ln = f.nextLine().split("");
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = ln[j].charAt(0);
                    shadow[i][j] = Integer.MAX_VALUE;
                }
            }
            for(int i=0; i<rows; i++){
                for (int j = 0; j < cols; j++) {
                    if(mat[i][j]=='B'){
                        bears.add(new int[]{i,j});
                    }
                    if(mat[i][j]=='A'){
                        alligators.add(new int[]{i,j});
                    }
                    if(mat[i][j]=='V'){
                        mat[i][j] = 'R';
                    }
                    if(mat[i][j]=='Q'){
                        if(isAdj(i,j,mat)){
                            mat[i][j] = 'm';
                        }
                    }
                    if(mat[i][j]=='S'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j]=='E'){
                        er = i;
                        ec = j;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(mat[i][j]=='m'){
                        mat[i][j] = 'M';
                    }
                }
            }
            for(int[] nums : bears){
                fillArea(nums[0], nums[1], 2);
            }
            for(int[] nums : alligators){
                fillArea(nums[0], nums[1], 1);
            }
            Queue<node> q = new LinkedList<>();
            q.offer(new node(sr,sc, 0));

            while(!q.isEmpty()){
                node cur = q.poll();
                int r= cur.r;
                int c= cur.c;
                int moves = cur.moves;
                if( r<0 || c<0 || r>=mat.length || c>=mat[0].length ||
                        moves >= shadow[r][c] || mat[r][c] == 'R' || mat[r][c] =='Q'){
                    continue;
                }
                shadow[r][c] = moves;
                if(mat[r][c]=='E'){
                    bmoves = Math.min(moves, bmoves);
                }
                int moveCost = 1;
                if(mat[r][c]=='M'){
                    moveCost = 3;
                }
                if(mat[r][c] == 'T')
                    moveCost = 2;
                q.offer(new node(r+1,c,moves+moveCost));
                q.offer(new node(r-1,c,moves+moveCost));
                q.offer(new node(r,c+1,moves+moveCost));
                q.offer(new node(r,c-1,moves+moveCost));
            }
//            System.out.println(bmoves+" "+time);
            if(bmoves<= time){
                System.out.println("Free at last, Free at last. "+ (time-bmoves)+" hour(s) to spare.");
            }
            else System.out.println("Smokey the Bear is en route.");
        }

        f.close();
    }
    
    class node{
        int r;
        int c;
        int moves;
        public node(int r, int c, int moves){
            this.r=r;
            this.c=c;
            this.moves=moves;
        }
    }

    boolean isAdj(int r, int c,char[][] mat){
        for(int i = Math.max(0,r-1); i<=Math.min(mat.length,r+1); i++){
            if(mat[i][c]=='T'){

                return true;
            }
        }
        for(int i = Math.max(0,c-1); i<=Math.min(mat.length,c+1); i++){
            if(mat[r][c]=='T'){
                return true;
            }
        }
        return false;
    }

    void fillArea(int r, int c, int size){
        for(int i = Math.max(0,r-size); i<=Math.min(r+size,mat.length-1); i++){
            for(int j = Math.max(0,c-size); j<=Math.min(c+size,mat[i].length-1); j++){
                mat[i][j] = 'R';
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        new claudius().run();
    }
}
