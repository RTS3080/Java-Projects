import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prob10 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Prob10.in.txt"));
        int n = in.nextInt(); in.nextLine();
        while (n-- > 0) {
            String[] s = in.nextLine().split(",");
            String[] l2 = in.nextLine().split(",");
            String[] l3 = in.nextLine().split(",");
            int row = Integer.parseInt(s[0]), col = Integer.parseInt(s[1]);
            int startR =  Integer.parseInt(l2[0]), startC =  Integer.parseInt(l2[1]);
            int endR =  Integer.parseInt(l3[0]), endC =  Integer.parseInt(l3[1]);
            int color1 = (startR%2)^(startC%2);
            int color2 = (endR%2)^(endC%2);
            System.out.println((color1==color2)?"Yes":"No");
        }
    }
}
