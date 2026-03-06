import java.util.*;
import java.io.*;

public class Prob17{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Prob17".toLowerCase()+".in.txt"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s = f.nextLine();
            char[][] mat = new char[3][3];
            mat = toMat(s);
            boolean found = false;

            for (int i = 0; i < mat.length; i++) {
                if (col(mat,'X', i)){
                    System.out.println(s + " = X WINS");
                    found = true;
                    break;
                }
                if (col(mat,'O', i)){
                    System.out.println(s + " = O WINS");
                    found = true;
                    break;
                }
                if (row(mat,'X', i)){
                    System.out.println(s + " = X WINS");
                    found = true;
                    break;
                }
                if (row(mat,'O', i)){
                    System.out.println(s + " = O WINS");
                    found = true;
                    break;
                }
            }
            if(!found){
                boolean digO = diag(mat, 'O');
                boolean digX = diag(mat, 'X');
                if(digO){
                    System.out.println(s + " = O WINS");
                }
                else if(digX){
                    System.out.println(s + " = X WINS");
                }
                System.out.println(s + " = TIE");
            }

        }
        f.close();
    }

    private char[][] toMat(String s ) {
        char[][] mat = new char[3][3];
        mat[0] = s.substring(0,3).toCharArray();
        mat[1] = s.substring(3,6).toCharArray();
        mat[2] = s.substring(6,9).toCharArray();
        return mat;
    }

    public boolean row(char[][] mat, char c , int i){
        for (int n =0; n<mat[i].length; n++){
            if(mat[i][n] != c){
                return false;
            }
        }
        return true;
    }

    public boolean col(char[][] mat, char c , int col){
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col] != c){return false;}
        }
        return true;
    }

    public boolean diag(char[][] mat, char c){

        boolean result1 = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][i] != c) {
                result1 = false;
                break;
            }
        }
        if(result1){return true;}
        result1 = true;
        for (int n = mat.length-1; n>-1 ; n--) {
            if (mat[n][n] != c) {
                result1 = false;
                break;
            }
        }
        return result1;
    }
    public static void main(String[] args) throws FileNotFoundException{
        new Prob17().run();
    }
}
