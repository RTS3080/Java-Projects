import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class harish{
char[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("harish".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            mat = new char[5][5];

            for(int row = 0; row < mat.length; row++){
                mat[row] = f.next().toCharArray();
            }
            f.next();
            int numArchers =0;
            boolean valid = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(mat[i][j] == 'a'){
                        valid &=checkSides(i,j);
                        numArchers++;
                    }
                }
            }
            valid &= numArchers ==9;
            if(valid){
                System.out.println("valid");
            }
            else System.out.println("invalid");
        }
        f.close();
    }
    boolean checkSides(int r, int c){
        boolean valid = false;
        for (int i = r-2; i <= r + 2; i+=4) {
            for (int j = c-2; j <= c+2; j+=4) {
                if(i< 0 || i >= 5 || j < 0 || j >= 5){
                    continue;
                }
                if(mat[i][j] == 'a'){
                    valid = true;
//                    System.out.println(i+" "+j+" | "+r+" "+c);
                }
            }
        }
        return !valid;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new harish().run();
    }
}
