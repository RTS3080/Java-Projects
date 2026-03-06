import java.util.*;
import java.io.*;
import java.awt.*;

public class maze{
    int[] rMoves = {1, -1, 0, 0};
    int[] cMoves = {0, 0, -1, 1};
    int[][][] shadow;
    char[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("maze".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int c = f.nextInt();
            int r = f.nextInt(); f.nextLine();
            int[][] starts = new int[3][2];
            int endR = -1; int endC = -1;
            shadow=new int[3][r][c];
            mat=new char[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < 3; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 'A'){
                        starts[0][0] = i;
                        starts[0][1] = j;
                    }
                    else if(mat[i][j] == 'M'){
                        starts[1][0] = i;
                        starts[1][1] = j;
                    }
                    else if(mat[i][j] == 'E'){
                        starts[2][0] = i;
                        starts[2][1] = j;
                    }
                    else if(mat[i][j] == 'K'){
                        endR = i;
                        endC = j;
                    }
                }
            }
            int[] moves = new int[3];
            String s = "";
            for (int i = 0; i < 3; i++) {
//                Node n = new Node(starts[i][0], starts[i][1], 0, i);
//                bfs(n);
                dfs(starts[i][0], starts[i][1], 0, i);
                moves[i]= shadow[i][endR][endC];
                if(moves[i] == Integer.MAX_VALUE){
                    moves[i] = -1;
                }
                s+=moves[i]+" ";
            }
            System.out.println(s.trim());
        }
        f.close();
    }
    void bfs(Node n){
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int moves = cur.moves;
            int pos = cur.pos;
            if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || shadow[pos][r][c] <=moves || mat[r][c] == 'X'){
                continue;
            }
            shadow[pos][r][c] = moves;
            if(mat[r][c] == 'K'){
                break;
            }
            for (int i = 0; i < 4; i++) {
                q.offer(new Node(r+rMoves[i], c+cMoves[i], moves+1, pos));
            }
        }
    }
    void dfs(int r, int c, int moves, int pos){
        if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || shadow[pos][r][c] <=moves || mat[r][c] == 'X'){
            return;
        }
        shadow[pos][r][c] = moves;
        for (int i = 0; i < 4; i++) {
            dfs(r+rMoves[i], c+cMoves[i], moves+1, pos);
        }
    }
    class Node{
        int r;
        int c;
        int moves;
        int pos;
        public Node(int r, int c, int moves, int pos){
            this.r = r;
            this.c = c;
            this.moves = moves;
            this.pos = pos;
        }
        public String toString(){
            return (r+" "+c+" "+moves+" "+pos);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new maze().run();
    }
}
