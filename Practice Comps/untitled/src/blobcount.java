import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class blobcount {

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("blobcount".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            int cases = f.nextInt();

            char[][] mat = new char[rows][cols];
            f.nextLine();

            for (int i = 0; i < rows; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
            }

            for (int i = 0; i < cases; i++) {
                int r = f.nextInt() - 1;
                int c = f.nextInt() - 1;

                int er = r, ec = c;
                if (mat[r][c] != '*') {
                    System.out.println("NO BLOB");
                    continue;
                }

                while (er < rows && mat[er][c] == '*') er++;
                while (ec < cols && mat[r][ec] == '*') ec++;
                System.out.println((er - r) * (ec - c));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new blobcount().run();
    }
}
