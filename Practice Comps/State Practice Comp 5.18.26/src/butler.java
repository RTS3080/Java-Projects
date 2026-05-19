import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class butler{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("butler".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        while (f.next().equals("START")) {
            int start = f.nextInt();
            int rooms = f.nextInt();
            f.nextLine();

            int[] deg = new int[rooms];
            int count = 0;

            for (int i = 0; i < rooms; i++) {
                String[] tokens = f.nextLine().trim().split(" +");


                for (String next : tokens) {
                    if (next.equals("")) {continue;}
                    deg[Integer.parseInt(next)]++;
                    deg[i]++;
                    count++;
                }
            }

            int even = 0;

            for (int d : deg) {
                if (d % 2 == 0) even++;
            }

            if (start == 0 && even == rooms) System.out.println("YES " + count);
            else if (start != 0 && even == rooms - 2 && (deg[start] & deg[0] & 1) == 1) {
                System.out.println("YES " + count);
            } else {
                System.out.println("NO");
            }

            f.nextLine();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new butler().run();
    }
}
