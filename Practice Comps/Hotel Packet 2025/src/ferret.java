import java.util.*;
import java.io.*;
import java.awt.*;

public class ferret{

    String [][] mat;
    boolean out;
    ArrayList<Integer> LR;
    ArrayList<Integer> LC;


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ferret".toLowerCase()+".dat"));

        while (f.hasNext()){
            f.next();
            out = false;
            int c = f.nextInt();
            int r = f.nextInt();
            mat = new String [r][c];
            f.nextLine();
            for (int i = 0; i < r; i++) {
                mat[i] = f.nextLine().split("");
            }
            int sc = 0;
            for (int i = 0; i < c; i++) {
                if (mat[0][i].equals("L")){
                    sc = i;
                    break;
                }
            }

            LR = new ArrayList<>();
             LC = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (mat[i][j].equals("S")){
                        LR.add(i);
                        LC.add(j);
                    }
                }
            }
            recur(0,sc,0);
            System.out.println(out?"FERRET":"GARRET");
            f.nextLine();
        }

        f.close();
    }

    public void recur (int r, int c, int t ){
        if (r<mat.length&&r>=0&&c<mat[0].length&&c>=0) {

            if (out) {
                return;
            }
            if (mat[r][c].equals("P")) {
                return;
            }
            if (t % 4 == 0) {
                for (int i = 0; i < LR.size(); i++) {
                    if (r <= LR.get(i) && c == LC.get(i)) {
                        return;
                    }
                }
            }
            if (t % 4 == 1) {
                for (int i = 0; i < LR.size(); i++) {
                    if (c >= LC.get(i) && r == LR.get(i)) {
                        return;
                    }
                }
            }
            if (t % 4 == 2) {
                for (int i = 0; i < LR.size(); i++) {
                    if (r >= LR.get(i) && c == LC.get(i)) {
                        return;
                    }
                }
            }
            if (t % 4 == 3) {
                for (int i = 0; i < LR.size(); i++) {
                    if (c <= LC.get(i) && r == LR.get(i)) {
                        return;
                    }
                }
            }
            if (mat[r][c].equals("G")) {
                out = true;
            }
            recur(r + 1, c - 1, t + 1);
            recur(r + 1, c, t + 1);
            recur(r + 1, c + 1, t + 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new ferret().run();
    }
}
