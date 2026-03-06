import java.util.*;
import java.io.*;

public class Prob11 {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("Prob11".toLowerCase() + ".in.txt"));
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int cr = f.nextInt(), cg = f.nextInt(), cb = f.nextInt();
            int T = f.nextInt();
            int fr = f.nextInt(), fg = f.nextInt(), fb = f.nextInt();
            int br = f.nextInt(), bg = f.nextInt(), bb = f.nextInt();

            boolean fore = Math.sqrt(Math.pow((cr - fr), 2) + Math.pow((cg - fg), 2) + Math.pow((cb - fb), 2)) >=T;
            boolean back = Math.sqrt(Math.pow((cr - br), 2) + Math.pow((cg - bg), 2) + Math.pow((cb - bb), 2) )>=T;


            if (fore){
                System.out.println(fr + " " + fg + " " + fb);

            }
            else {
                System.out.println(br + " " + bg + " " + bb);
            }
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new Prob11().run();
    }
}
