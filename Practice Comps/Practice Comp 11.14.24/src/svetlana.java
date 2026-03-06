import java.util.*;
import java.io.*;

public class svetlana{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("svetlana".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        for (int CASE = 1; CASE <= cases; CASE++){
            f.nextLine();
            String[][] matrix = new String[8][8];

            for (int r = 0; r < 8; r++){
                for (int c = 0; c < 8; c++){
                    matrix[r][c] = f.next();
                }
            }

            int black = 0;
            int red = 0;
            for (int r = 0; r < 8; r++){
                for (int c = 0; c < 8; c++){
                    if (matrix[r][c].equals("r")){
                        if (valid(r+1, c+1) && matrix[r+1][c+1].equals("_")) red++;
                        if (valid(r+1, c-1) && matrix[r+1][c-1].equals("_")) red++;

                        if (valid(r+2, c+2) && matrix[r+2][c+2].equals("_") && (matrix[r+1][c+1].equals("b") || matrix[r+1][c+1].equals("B"))) red++;
                        if (valid(r+2, c-2) && matrix[r+2][c-2].equals("_") && (matrix[r+1][c-1].equals("b") || matrix[r+1][c-1].equals("B"))) red++;
                    }
                    if (matrix[r][c].equals("b")){
                        if (valid(r-1, c+1) && matrix[r-1][c+1].equals("_")) black++;
                        if (valid(r-1, c-1) && matrix[r-1][c-1].equals("_")) black++;

                        if (valid(r-2, c+2) && matrix[r-2][c+2].equals("_") && (matrix[r-1][c+1].equals("r") || matrix[r-1][c+1].equals("R"))) black++;
                        if (valid(r-2, c-2) && matrix[r-2][c-2].equals("_") && (matrix[r-1][c-1].equals("r") || matrix[r-1][c-1].equals("R"))) black++;
                    }
                    if (matrix[r][c].equals("R")){
                        if (valid(r+1, c+1) && matrix[r+1][c+1].equals("_")) red++;
                        if (valid(r+1, c-1) && matrix[r+1][c-1].equals("_")) red++;
                        if (valid(r-1, c+1) && matrix[r-1][c+1].equals("_")) red++;
                        if (valid(r-1, c-1) && matrix[r-1][c-1].equals("_")) red++;

                        if (valid(r+2, c+2) && matrix[r+2][c+2].equals("_") && (matrix[r+1][c+1].equals("b") || matrix[r+1][c+1].equals("B"))) red++;
                        if (valid(r+2, c-2) && matrix[r+2][c-2].equals("_") && (matrix[r+1][c-1].equals("b") || matrix[r+1][c-1].equals("B"))) red++;
                        if (valid(r-2, c+2) && matrix[r-2][c+2].equals("_") && (matrix[r-1][c+1].equals("b") || matrix[r-1][c+1].equals("B"))) red++;
                        if (valid(r-2, c-2) && matrix[r-2][c-2].equals("_") && (matrix[r-1][c-1].equals("b") || matrix[r-1][c-1].equals("B"))) red++;
                    }
                    if (matrix[r][c].equals("B")){
                        if (valid(r+1, c+1) && matrix[r+1][c+1].equals("_")) black++;
                        if (valid(r+1, c-1) && matrix[r+1][c-1].equals("_")) black++;
                        if (valid(r-1, c+1) && matrix[r-1][c+1].equals("_")) black++;
                        if (valid(r-1, c-1) && matrix[r-1][c-1].equals("_")) black++;

                        if (valid(r+2, c+2) && matrix[r+2][c+2].equals("_") && (matrix[r+1][c+1].equals("r") || matrix[r+1][c+1].equals("R"))) black++;
                        if (valid(r+2, c-2) && matrix[r+2][c-2].equals("_") && (matrix[r+1][c-1].equals("r") || matrix[r+1][c-1].equals("R"))) black++;
                        if (valid(r-2, c+2) && matrix[r-2][c+2].equals("_") && (matrix[r-1][c+1].equals("r") || matrix[r-1][c+1].equals("R"))) black++;
                        if (valid(r-2, c-2) && matrix[r-2][c-2].equals("_") && (matrix[r-1][c-1].equals("r") || matrix[r-1][c-1].equals("R"))) black++;
                    }
                }
            }
            System.out.println("Test case: "+CASE);
            System.out.println("Red valid single moves: "+red);
            System.out.println("Black valid single moves: "+black);
            if (f.hasNextLine()) f.nextLine();
        }

        f.close();
    }

    public boolean valid(int r, int c){
        return r >= 0 && c >= 0 && c < 8 && r < 8;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new svetlana().run();
    }
}
