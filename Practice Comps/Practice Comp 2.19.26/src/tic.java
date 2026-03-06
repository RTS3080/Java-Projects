import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class tic{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tic".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char[][] mat = new char[3][3];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(mat[i], ' ');
            }
            boolean turn = true;
            int times2=f.nextInt(); f.nextLine();
            int abcd = 0;
            while(abcd++ < times2){
                int r = f.nextInt(); int c = f.nextInt();
                if(turn){
                    mat[r][c] = 'X';
                }
                else{
                    mat[r][c] = 'O';
                }
                turn ^=true;
            }
            char winner = checkWinner(mat);
            for (int i = 0; i < 3; i++) {
                char[] ch = mat[i];
                System.out.println(ch[0] + "|" + ch[1] + "|" + ch[2]);
                if(i!=2) System.out.println("-----");
            }
            if(winner == '-' && times2 !=9){
                System.out.println("Incomplete");
            }
            else if(winner == '-'){
                System.out.println("Tie Game!");
            }
            else{System.out.println(winner+" wins!");}
        }
        f.close();
    }
    char checkWinner(char[][] mat){
        char winner = '-';
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if(mat[i][j] == 'X'){
                    count++;
                }
                else if(mat[i][j] == 'O'){
                    count--;
                }
            }
            if(count == 3){
                return 'X';
            }
            else if(count == -3){
                return 'O';
            }
        }
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if(mat[j][i] == 'X'){
                    count++;
                }
                else if(mat[j][i] == 'O'){
                    count--;
                }
            }
            if(count == 3){
                return 'X';
            }
            else if(count == -3){
                return 'O';
            }
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<3 && j<3){
            if(mat[i][j] == 'X'){
                count++;
            }
            else if(mat[i][j] == 'O'){
                count--;
            }
            i++;
            j++;
        }
        if(count == 3){
            return 'X';
        }
        else if(count == -3){
            return 'O';
        }
        i = 2;
        j = 0;
        count = 0;
        while(i<3 && j<3){
            if(mat[i][j] == 'X'){
                count++;
            }
            else if(mat[i][j] == 'O'){
                count--;
            }
            i--;
            j++;
        }
        if(count == 3){
            return 'X';
        }
        else if(count == -3){
            return 'O';
        }
        return '-';
    }

    public static void main(String[] args) throws FileNotFoundException{
        new tic().run();
    }
}
