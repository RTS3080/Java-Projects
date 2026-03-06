import java.util.*;
import java.io.*;

public class C{
    char[][] m;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("C".toLowerCase()+".txt"));
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            int r = f.nextInt(), c = f.nextInt();
            f.nextLine();
           m = new char[r][c];
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            long[] mx = new long[2];
            for (int sr = 0; sr < r; sr++) {
                for (int sc = 0; sc < c; sc++) {
                    for (int er = sr; er < r; er++) {
                        for (int ec = sc; ec < c; ec++) {
                            long size = (long) (er - sr + 1) * (ec - sc + 1);
                            if (valid(sr, sc, er, ec, 'x')) {
                                mx[0] = Math.max(mx[0], size);
                            }
                            if (valid(sr, sc, er, ec, 'o')) {
                                mx[1] = Math.max(mx[1], size);
                            }
                        }
                    }
                }
            }
            System.out.println("Grid " + asdf + ": " + mx[0] + " " + mx[1]);
        }
        f.close();
    }

    public boolean valid(int sr, int sc, int er, int ec, char ch){
        for(int i = sr;i<=er;i++){
            for(int j = sc;j<=ec;j++){
                if(m[i][j] != ch) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new C().run();
    }
}
