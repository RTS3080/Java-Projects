import java.util.*;
import java.io.*;

public class DrawingTheBorder{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("DrawingTheBorder".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt();
            int c = f.nextInt();
            int borderSize = f.nextInt(); f.nextLine();
            char[][] mat = new char[r+(2*borderSize)][c+(2*borderSize)];
            for(int i=borderSize; i<mat.length-borderSize; i++){
                String ln = f.nextLine();
//                System.out.println(ln);
                for(int j=borderSize; j<mat[0].length-borderSize; j++){
                    mat[i][j] = ln.charAt(j-borderSize);
                }
            }
            for (int i = 0; i < mat.length; i++) {
                if(i<borderSize || mat.length-i<=borderSize){
                    Arrays.fill(mat[i],'#');
                }
                else {
                    for (int j = 0; j < mat[0].length; j++) {
                        if(j<borderSize){
                            mat[i][j] = '#';
                        }
                        if(mat[i].length-j<=borderSize){
                            mat[i][j] = '#';
                        }
                    }
                }
            }
            for(char[] chars : mat){
                for(char ch : chars){
                    System.out.print(ch);
                }
                System.out.println();
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new DrawingTheBorder().run();
    }
}
