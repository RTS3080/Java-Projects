import java.util.*;
import java.io.*;

public class harish{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("harish".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            char[][] mat = new char[5][5];
            for (int i = 0; i < 5; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            f.nextLine();

            boolean valid = true;
            for (int i = 0; i < 5 && valid; i++) {
                for (int j = 0; j < 5 && valid; j++) {
                    if (mat[i][j] != 'a') continue;
                    int x = i - 2;
                    int y = j - 2;
                    if (x >= 0 && y >= 0) valid &= mat[x][y] != 'a';

                    x = i - 2;
                    y = j + 2;
                    if (x >= 0 && y < 5) valid &= mat[x][y] != 'a';

                    x = i + 2;
                    y = j - 2;
                    if (y >= 0 && x < 5) valid &= mat[x][y] != 'a';

                    x = i + 2;
                    y = j + 2;
                    if (x < 5 && y < 5) valid &= mat[x][y] != 'a';
                }
            }
            if (valid) System.out.println("valid");
            else System.out.println("invalid");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new harish().run();
    }
}
