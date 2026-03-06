import java.util.*;
import java.io.*;
import java.awt.*;

public class Mipmapping{

    public int[][] average(int[][] mat, int stride){
        int[][] out = new int[mat.length/stride][mat[0].length/stride];
        for (int i = 0; i < out.length; i++){
            for (int j = 0; j < out[0].length; j++){


                for (int k = 0; k < stride; k++){
                    for (int l = 0; l < stride; l++){
                        out[i][j] += mat[i*stride+k][j*stride+l];
                    }
                }
                out[i][j] = out[i][j] / (stride*stride);


            }
        }
        return out;
    }
    String pad(String a){
        if (a.length() == 1){
            return "0"+a;
        }
        return a;
    }
    public void print(int[][] alpha, int[][] red, int[][] green, int[][] blue){
        for (int i = 0; i < alpha.length; i++){
            for (int j = 0; j < alpha[0].length; j++){
                System.out.print("0x");
                System.out.print(pad(Integer.toHexString(alpha[i][j])));
                System.out.print(pad(Integer.toHexString(red[i][j])));
                System.out.print(pad(Integer.toHexString(green[i][j])));
                System.out.print(pad(Integer.toHexString(blue[i][j])));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void scaleDown(int[][] alpha, int[][] red, int[][] green, int[][] blue){
        int[][] newAlpha = average(alpha, 2);
        int[][] newRed = average(red, 2);
        int[][] newGreen = average(green, 2);
        int[][] newBlue = average(blue, 2);

        print(newAlpha, newRed, newGreen, newBlue);
        if (alpha.length == 1 || alpha[0].length == 1){
            return;
        }
        scaleDown(newAlpha, newRed, newGreen, newBlue);

    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Mipmapping".toLowerCase()+".dat"));

        int cses = f.nextInt();
        for (int tst = 0; tst < cses; tst++) {
            int h = f.nextInt();
            int w = f.nextInt();
            int[][] a = new int[h][w];
            int[][] r = new int[h][w];
            int[][] g = new int[h][w];
            int[][] b = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    String line = f.next();
                    line = line.substring(2);
                    a[i][j] = Integer.parseInt(line.substring(0, 2),16);
                    r[i][j] = Integer.parseInt(line.substring(2, 4),16);
                    g[i][j] = Integer.parseInt(line.substring(4, 6),16);
                    b[i][j] = Integer.parseInt(line.substring(6, 8),16);
                }
            }

            if (Math.log(h)/Math.log(2) % 1 != 0) {
                System.out.println("NO REDUCTION POSSIBLE\n");
                continue;
            }
            if (Math.log(w)/Math.log(2) % 1 != 0){
                System.out.println("NO REDUCTION POSSIBLE\n");
                continue;
            }
//            print(a, r, g, b);
            scaleDown(a,r,g,b);
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Mipmapping().run();
    }
}
