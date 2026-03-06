import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

public class Bart{

    char[][] mat;
    int[][] shadow;
    int[][] black;
    HashMap<Character, int[]> portals;
    int holeR;
    int holeC;
    int bmoves;
    int rows;
    int cols;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Bart".toLowerCase()+".dat"));
        int times=f.nextInt();
        while(times-->0){
            rows = f.nextInt(); cols = f.nextInt();
            f.nextLine();
            mat = new char[rows][cols];
            shadow = new int[rows][cols];
            black = new int[rows][cols];
            portals = new HashMap<>();
            bmoves  = Integer.MAX_VALUE;
            int startR = -1;
            int startC = -1;
            for(int i=0; i<rows; i++){
                mat[i] = f.nextLine().toCharArray();
//                System.out.println(Arrays.toString(mat[i]));
                for(int j=0; j<cols; j++){
                    shadow[i][j] = Integer.MAX_VALUE;
                    black[i][j] =0;
                    if(mat[i][j] == '$'){
                        startR = i;
                        startC = j;
                    }
                    if(mat[i][j] == '@'){
                        holeR = i;
                        holeC = j;
                    }
                    if(mat[i][j] >=97 && mat[i][j] <=122){
                        portals.put((char)(mat[i][j] - 32), new int[]{i,j});
                    }
                }
            }
//            for(Map.Entry e : portals.entrySet()){
//                System.out.println(e+" "+e.toString());
//                System.out.println(e.getKey() +" "+ Arrays.toString((int[])e.getValue()));
//            }
            incBlackHole(0);
//            for (int[] ints : black) {
//                for (int anInt : ints) {
//                    System.out.print(anInt);
//                }
//                System.out.println();
//            }
//            System.out.println();
            recur(startR,startC,0);
            System.out.println(bmoves!=Integer.MAX_VALUE?"Matthew McConahey says hi "+bmoves:"YOU SUCK");
//            for(int i=0; i<rows; i++){
//                for(int j=0; j<cols; j++){
//                    System.out.printf("%11s",shadow[i][j]+" ");
//                }
//                System.out.println();
//            }

            
        }
        f.close();
    }
    
    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>mat.length-1 || c>mat[0].length-1 || moves>shadow[r][c] || 
                mat[r][c] == '#'  || black[r][c] == -1){
            return;
        }
        shadow[r][c] = moves;
//        System.out.println("BLACK HOLE BITCH "+moves);
        incBlackHole(moves/3);
        if(mat[r][c] == '^'){
            bmoves = moves;
            return;
        }
        if(mat[r][c] >=65 && mat[r][c] <=90){

            recur(portals.get(mat[r][c])[0], portals.get(mat[r][c])[1], moves+1);
        }
        if(black[r][c] == 1){
            recur(r+1, c, moves+2);
            recur(r-1, c, moves+2);
            recur(r, c+1, moves+2);
            recur(r, c-1, moves+2);
        }
        else{
            recur(r+1, c, moves+1);
            recur(r-1, c, moves+1);
            recur(r, c+1, moves+1);
            recur(r, c-1, moves+1);
        }
        
    }
    public void incBlackHole(int dist){
        int r = holeR;
        int c = holeC;
        dist +=2;
        black = new int[rows][cols];
        for(int i = Math.max(0,r-dist); i<= Math.min(mat.length-1,r+dist); i++){
            for(int j = Math.max(0,c-dist); j<= Math.min(mat[0].length-1,c+dist); j++){
                black[i][j] = 1;
            }
        }

        dist -=2;
        for(int i = Math.max(r-dist,0); i<=Math.min(r+dist,black.length-1); i++){
            for(int j = Math.max(c-dist,0); j<=Math.min(c+dist,black[0].length-1); j++){

                black[i][j] = -1;
            }
        }

//        for (int[] ints : black) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
//        System.out.println();
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Bart().run();
    }
}
