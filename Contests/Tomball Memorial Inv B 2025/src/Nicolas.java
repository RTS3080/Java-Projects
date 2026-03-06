import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Nicolas{

    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Nicolas".toLowerCase()+".dat"));
//        Scanner f = new Scanner(new File("nicolasJudge.dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt(); f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for(int i = 0; i < rows; i++){
                char[] ln = f.nextLine().toCharArray();
                for(int j = 0; j < cols; j++){
                    mat[i][j] = ln[j];
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                    if(mat[i][j] == 'E'){
                        er = i;
                        ec = j;
                    }
                }
            }
            Queue<Node> q = new LinkedList<>();
            String directions = "NESW";
            char[] dirs = directions.toCharArray();
            int[] dirMods = {-1,1,1,-1};
            q.add(new Node(sr,sc,'0',0 ));
            while(!q.isEmpty()){
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                char dir = cur.dir;
                int turns = cur.turns;
                if(r<0 || c<0 || r>=mat.length || c>=mat[r].length){
                    System.out.println(r+" "+c+" "+turns);
                    continue;
                }
                if(turns-1>shadow[r][c]){
                    System.out.println(r+" "+c+" "+turns+" "+shadow[r][c] );
                    continue;
                }
//                System.out.println("WHY");
                if(mat[r][c] == '#'){
//                    System.out.println("HIT");
                    int tempr = r;
                    int tempc = c;
                    if(dir =='N'){
                        tempr++;
                    }
                    if(dir =='S'){
                        tempr--;
                    }
                    if(dir =='E'){
                        tempc--;
                    }
                    if(dir =='W'){
                        tempc++;
                    }
                    shadow[tempr][tempc] = turns;
                    System.out.println(mat[r][c]);
                    for(char di : dirs){
                        if(di!= dir || Math.abs(directions.indexOf(di)-directions.indexOf(dir))==2)
                            continue;
                        q.offer(new Node(tempr,tempc,di,turns+1));
                    }
                }


                else{
                    if(dir == 'N' || dir == '0') {
                        q.offer(new Node(r-1, c, 'N', turns));
                    }
                    if(dir == 'E' || dir == '0') {
                        q.offer(new Node(r, c+1, 'E', turns));
                    }
                    if(dir == 'S' || dir == '0') {
                        q.offer(new Node(r+1, c, 'S', turns));
                    }
                    if(dir == 'W' || dir == '0') {
                        q.offer(new Node(r, c-1, 'W', turns));
                    }
                }
            }
            System.out.println(shadow[er][ec]);
            for(int[] nums : shadow){
                for (int i = 0; i < nums.length; i++) {
                    System.out.printf("%10d ",nums[i]);
                }
                System.out.println();
            }
            for(char[] chs : mat){
                System.out.println(chs);
            }
            System.out.println();
        }
        f.close();
    }

    class Node{
        int r;
        int c;
        char dir;
        int turns;
        public Node(int r, int c, char dir, int turns){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.turns = turns;
        }
        public String toString(){
            return r+" "+c+" "+dir+" "+turns;
        }
    }

    public int[] temps(int r, int c, char dir){
        int tempr = r;
        int tempc = c;
        if(dir =='N'){
            tempr++;
        }
        if(dir =='S'){
            tempr--;
        }
        if(dir =='E'){
            tempc--;
        }
        if(dir =='W'){
            tempc++;
        }
        return new int[]{tempr,tempc};
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Nicolas().run();
    }
}
