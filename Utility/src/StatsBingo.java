import java.util.*;
import java.io.*;

public class StatsBingo{

    public void run() throws FileNotFoundException{
        String[][] mat = new String[5][5];
        String[] poss = "G G G B B R".split(" ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int ind1 = (int) (Math.random() * 6);
                int ind2 = (int) (Math.random() * 6);
                mat[i][j] = poss[ind1] + poss[ind2];
            }
        }
        for(String[] strings : mat){
            for (String string : strings) {
                System.out.print(string+"\u001B[0m ");
            }
            System.out.println("\u001B[0m");
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new StatsBingo().run();
    }
}
