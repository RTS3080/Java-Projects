import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class haru{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("haru".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        String DIRS = "UDLR";
        int[][] Ds = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int cases = f.nextInt();
        loop:
        while(cases-->0){
            int len = f.nextInt();
            int oneX = f.nextInt();
            int oneY = f.nextInt();
            String oneDirs = f.next();

            int twoX = f.nextInt();
            int twoY = f.nextInt();
            String twoDirs = f.next();

            int lastOneX = -1;
            int lastOneY = -1;

            int lastTwoX = -1;
            int lastTwoY = -1;

            boolean[][] visited = new boolean[101][101];
            for (int i = 0; i < len; i++){
                visited[oneX][oneY] = true;
                visited[twoX][twoY] = true;

                lastOneX = oneX;
                lastOneY = oneY;

                lastTwoX = twoX;
                lastTwoY = twoY;

                int[] oneD = Ds[DIRS.indexOf(oneDirs.charAt(i))];
                int[] twoD = Ds[DIRS.indexOf(twoDirs.charAt(i))];

                oneX += oneD[0];
                oneY += oneD[1];
                twoX += twoD[0];
                twoY += twoD[1];

                boolean oneSpike = false;
                boolean twoSpike = false;

                if (!inBounds(oneX, oneY)) oneSpike = true;
                else if (visited[oneX][oneY]) oneSpike = true;

                if (!inBounds(twoX, twoY)) twoSpike = true;
                else if (visited[twoX][twoY]) twoSpike = true;


                if (oneX == lastTwoX && oneY == lastTwoY && twoX == lastOneX && twoY == lastOneY) {
                    System.out.println("HEAD ON");
                    continue loop;
                }

                if (oneSpike && twoSpike) {
                    System.out.println("DOUBLE SPIKE");
                    continue loop;
                }
                if (oneSpike) {
                    System.out.println("P2 WIN");
                    continue loop;
                }
                if (twoSpike) {
                    System.out.println("P1 WIN");
                    continue loop;
                }

                if (oneX == twoX && oneY == twoY) {
                    System.out.println("HEAD ON");
                    continue loop;
                }
            }
            System.out.println("DRAW");
        }


        f.close();
    }

    public boolean inBounds(int x, int y){
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new haru().run();
    }
}
