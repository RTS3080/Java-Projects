import java.util.*;
import java.io.*;

public class creeperCorridor{
    int[][] shadow;
    char[][] mat;
    int[][] manhatten;
    int result;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("creeperCorridor".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r= f.nextInt();
            int c= f.nextInt(); f.nextLine();
            int sr = -1, sc = -1, er = -1, ec = -1;
            mat = new char[r][c];
            shadow = new int[r][c];
            manhatten = new int[r][c];
            result = -1;
            ArrayList<int[]> creepers = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(shadow[i], -1);
                Arrays.fill(manhatten[i], Integer.MAX_VALUE);
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                    else if (mat[i][j] == 'E'){
                        er = i;
                        ec = j;
                    }
                    else if (mat[i][j] == 'C'){
                        creepers.add(new int[]{i,j});
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int minDist = Integer.MAX_VALUE;
                    for(int[] arr : creepers){
                        int d = Math.abs(i - arr[0]) + Math.abs(j - arr[1]);
                        minDist = Math.min(d, minDist);
                    }
                    manhatten[i][j] = minDist;
                }
            }
//            dfs(sr, sc, Integer.MAX_VALUE);
            bfs(sr, sc);
            System.out.println(result==-1?"Creeper, awww man":result);
        }
        f.close();
    }

    void dfs(int r, int c, int minManhatten){
        if(r<0 || r>=mat.length ||c<0 || c>=mat[0].length || (""+mat[r][c]).matches("[#C]")
         || shadow[r][c] >= minManhatten || minManhatten<=result){
            return;
        }
        minManhatten = Math.min(minManhatten, manhatten[r][c]);
        shadow[r][c]=minManhatten;
        if(mat[r][c] == 'E'){
            result = Math.max(result, minManhatten);
        }
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir : dirs){
            dfs(r+dir[0],c+dir[1],minManhatten);
        }
    }
    int bfs(int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc, Integer.MAX_VALUE});
        while(!q.isEmpty()){
            int[] arr= q.poll();
            int r = arr[0];
            int c = arr[1];
            int minManhatten = arr[2];
            if(r<0 || r>=mat.length ||c<0 || c>=mat[0].length || (""+mat[r][c]).matches("[#C]")
                    || shadow[r][c] >= minManhatten || minManhatten<=result){
                continue;
            }
            minManhatten = Math.min(minManhatten, manhatten[r][c]);
            shadow[r][c]=minManhatten;
            if(mat[r][c] == 'E'){

                result = Math.max(result, minManhatten);
            }
            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] dir : dirs){
                q.offer(new int[]{r+dir[0],c+dir[1],minManhatten});
            }
        }
        return result;
    }




    public static void main(String[] args) throws FileNotFoundException{
        new creeperCorridor().run();
    }
}
//import java.io.File;
//import java.util.*;
//
//public class creeperCorridor {
//    public static int [][] creeperDist;
//    public static void main(String[] args) throws Throwable {
//        new creeperCorridor().run();
//    }
//
//    public void run()  throws Throwable {
//        Scanner kb = new Scanner(new File("creepercorridor.dat"));
//
//        int N = kb.nextInt();
//
//        while(N-->0) {
//            int R = kb.nextInt(), C = kb.nextInt(); kb.nextLine();
//
//            char [][] mat = new char[R][C];
//
//            int sx = 0, sy = 0;
//            int ex = 0, ey = 0;
//
//            for(int x = 0; x < R; x++) {
//                mat[x] = kb.nextLine().trim().toCharArray();
//                for(int y = 0; y < C; y++) {
//                    if(mat[x][y] == 'S') {
//                        sx = x;
//                        sy = y;
//                    }
//                    if(mat[x][y] == 'E') {
//                        ex = x;
//                        ey = y;
//                    }
//                }
//            }
//            creeperFill(mat);
//            solve(sx, sy, ex, ey, mat);
//        }
//    }
//
//    public void creeperFill(char [][] mat) {
//        int R = mat.length;
//        int C = mat[0].length;
//        creeperDist = new int[R][C];
//        for(int x = 0; x < R; x++)
//            Arrays.fill(creeperDist[x], -2);
//        boolean [][] visited = new boolean[R][C];
//
//        int [] ai = {1, -1, 0 ,0};
//        int [] aj = {0, 0, 1, -1};
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0; i < R; i++) {
//            for(int j = 0; j < C; j++) {
//                if(mat[i][j] == 'C') {
//                    list.add(i);
//                    list.add(j);
//                    list.add(-1);
//                }
//                if(mat[i][j] == '#')
//                    visited[i][j] = true;
//            }
//        }
//
//        while(!list.isEmpty()) {
//            int i = list.removeFirst();
//            int j = list.removeFirst();
//            int v = list.removeFirst();
//
//            if(i < 0 || i >= R || j < 0 || j >= C) continue;
//            if(visited[i][j]) continue;
//
//            if(creeperDist[i][j] <= v && creeperDist[i][j] != -2) continue;
//
//            creeperDist[i][j] = v;
//
//            for(int a = 0; a < 4; a++) {
//                list.add(i + ai[a]);
//                list.add(j + aj[a]);
//                list.add(v + 1);
//            }
//        }
//    }
//
//    public void solve(int sx, int sy, int ex, int ey, char[][] mat) {
//        int answer = -1;
//
//        for(int x = mat.length * mat.length; x >= 0; x--) {
//            if(bfs(sx, sy, ex, ey, x, mat)) {
//                answer = x;
//                break;
//            }
//        }
//        if(answer == -1) {
//            System.out.println("Creeper, awww man");
//        } else {
//            System.out.println(answer + 1);
//        }
//    }
//
//    public boolean bfs(int sx, int sy, int ex, int ey, int maxDist, char[][] mat) {
//        int R = mat.length, C = mat[0].length;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(sx);
//        list.add(sy);
//
//        int [] ai = {1, -1, 0 ,0};
//        int [] aj = {0, 0, 1, -1};
//
//        boolean [][] visited = new boolean[R][C];
//
//        while(!list.isEmpty()) {
//            int x = list.removeFirst();
//            int y = list.removeFirst();
//
//            if(x < 0 || x >= R || y < 0 || y >= C) continue;
//            if(visited[x][y]) continue;
//            if(mat[x][y] == '#') continue;
//            if(creeperDist[x][y] < maxDist) continue;
//
//            visited[x][y] = true;
//
//            if(x == ex && y == ey) break;
//
//            for(int a = 0; a < 4; a++) {
//                int newX = x + ai[a];
//                int newY = y + aj[a];
//
//                list.add(newX);
//                list.add(newY);
//            }
//        }
//
//        return visited[ex][ey];
//    }
//}
