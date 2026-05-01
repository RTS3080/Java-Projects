import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class kenneth{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kenneth".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                board[i] = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            ArrayList<Integer> rowMistakes = new ArrayList<>();
            ArrayList<Integer> colMistakes = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                boolean[] isNum = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    isNum[board[i][j]] ^= true;
                }
//                System.out.println(Arrays.toString(isNum));
                boolean good = true;
                for(int j = 1; j < 10; j++){
                    good &=isNum[j];
                }
                if(!good){
                    rowMistakes.add(i);
                }
            }
            for (int i = 0; i < 9; i++) {
                boolean[] isNum = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    isNum[board[j][i]] ^= true;
                }
                boolean good = true;
                for(int j = 1; j < 10; j++){
                    good &=isNum[j];
                }
                if(!good){
                    colMistakes.add(i);
                }
            }
            System.out.print("GRID #"+times+": ");
            if(rowMistakes.isEmpty() && colMistakes.isEmpty()){
                System.out.println(" SOLUTION IS CORRECT");
            }
            else{
                System.out.println("NOT A SOLUTION");
                String r = ">> ROWS WITH ERRORS: ";
                if(rowMistakes.isEmpty()){
                    r+="NONE";
                }
                else{
                    for(int i : rowMistakes){
                        r+=1+i+" ";
                    }
                }
                System.out.println(r.trim());
                String c = ">> COLUMNS WITH ERRORS: ";
                if(colMistakes.isEmpty()){
                    c+="NONE";
                }
                else{
                    for(int i : colMistakes){
                        c+=1+i+" ";
                    }
                }
                System.out.println(c.trim());
            }
            System.out.println("=".repeat(12));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kenneth().run();
    }
}
