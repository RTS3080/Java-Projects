import java.util.*;
import java.io.*;

public class grinch{

    char[][] mat;
    int[][] shadow;
    int presents;
    int bmoves;
    ArrayList<point> ends;
    int endR;
    int endC;
//    long totTime;
    ArrayList<Integer> timeBuffer;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("grinch".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int row = f.nextInt(); int col = f.nextInt(); presents = f.nextInt();
            mat = new char[row][col];
            shadow = new int[row][col];
            bmoves = Integer.MAX_VALUE;
            timeBuffer = new ArrayList<>();
            ends = new ArrayList<>();
            int startR = -1; int startC = -1;
            int totPresents = 0;
            for(int i=0; i<row; i++){
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < col; j++) {
                    shadow[i][j] = Integer.MAX_VALUE;
                    if(mat[i][j] == 'R'){
                        startR = i;
                        startC = j;
                    }

                    if(mat[i][j] == 'T'){
                        totPresents++;
                        ends.add(new point(i,j));
                    }
                }
            }
            int numSolved = 0;
            boolean canSolve = true;

            for(point p: ends){
                endR = p.r;
                endC = p.c;
                System.out.println(startR+" "+startC+" "+p.r+" "+p.c);
                recur(startR,startC,0);
                mat[p.r][p.c] = '.';

                for (char[] chs : mat) {
                    for (char ch : chs) {
                        System.out.print(ch);
                    }
                    System.out.println();
                }

                timeBuffer.add(bmoves);
                if(bmoves == Integer.MAX_VALUE){
                    canSolve = false;
                    break;
                }

                else numSolved++;
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[i].length; j++) {
                        shadow[i][j] = Integer.MAX_VALUE;
                    }
                }
                ends.removeFirst();
            }
            Collections.sort(timeBuffer);
            int totTime = 0;
            for(int i=0; i<timeBuffer.size()-1; i++){
                totTime += timeBuffer.get(i)*2;
            }
            totTime+=timeBuffer.getLast();
//            System.out.println(totPresents+" "+numSolved);
            if(canSolve && numSolved == totPresents){
                System.out.println(totTime);
            }
            else System.out.println("Get Grinched");
            System.out.println(timeBuffer+"\n");


        }
        f.close();
    }


    public class point{
        int r;
        int c;
        public point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void recur(int r, int c, int moves){
        if(r<0 || c<0 || r>=mat.length || c>=mat[r].length || shadow[r][c] <=moves){
            return;
        }
        if(mat[r][c] =='#') {
            System.out.println("wall " + r + " " + c);
            return;
        }
        shadow[r][c] = moves;
        if(r==endR && c==endC){
            bmoves = Math.min(bmoves,moves);
        }
        recur(r+1,c,moves+1);
        recur(r-1,c,moves+1);
        recur(r,c+1,moves+1);
        recur(r,c-1,moves+1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new grinch().run();
    }
}
