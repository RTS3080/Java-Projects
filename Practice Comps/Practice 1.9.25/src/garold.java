import java.util.*;
import java.io.*;

public class garold{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("garold".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            char[][] mat = new char[9][9];
            for (int i = 0; i < 9; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            char[][][][] fin = new char[3][3][3][3];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    fin[i/3][j/3][i%3][j%3] = mat[i][j];
                }
            }

            char[][] end = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    end[i][j] = tictactoe(fin[i][j]);
                }
            }
            char winner = tictactoe(end);
            if(winner !='.')
                System.out.println("Player "+winner+" Won.");
            else System.out.println("Cat's Game.");
            for (int i = 0; i < 3; i++) {
                System.out.println(end[i]);
            }
        }
        f.close();
    }


    char tictactoe(char[][] mat){
        outer:
        for (int i = 0; i < 3; i++) {
            char start = mat[i][0];
            if(start == '.')
                continue outer;
            for (int j = 0; j < 3; j++) {
                if(mat[i][j] != start)
                    continue outer;
                if(j==2){
                    return start;
                }
            }
        }
        outer1:
        for (int i = 0; i < 3; i++) {
            char start = mat[0][i];
            if(start =='.')
                continue outer1;
            for (int j = 0; j < 3; j++) {
                if(mat[j][i] != start)
                    continue outer1;
                if(j==2){
                    return start;
                }
            }
        }
        if(mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])
            return mat[1][1];
        if(mat[2][0] == mat[1][1] && mat[1][1] == mat[0][2])
            return mat[1][1];
        return '.';
    }


    public static void main(String[] args) throws FileNotFoundException{
        new garold().run();
    }
}
