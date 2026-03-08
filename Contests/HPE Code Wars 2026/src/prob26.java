import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob26{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob26".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String[] ln = f.nextLine().split(",");
        int n = Integer.parseInt(ln[0]);
        int[][] sets = new int[n][2];

        int start = 0;

        for (int i = 1; i <= n; i++) {
            String[] set  = ln[i].trim().split(" ");
            int a= Integer.parseInt(set[0]);
            int b= Integer.parseInt(set[1]);
            sets[i-1][0]= a;
            sets[i-1][1]= b;

            start = Math.max(start, a);
        }

//        System.out.println(start);

//        System.out.println(Arrays.deepToString(sets));


        loop:
        for (int T = start+1; T <= 10_000_000; T++) {
            for (int i = 0; i < n; i++){
                if ( (T-sets[i][0]) % sets[i][1] != 0) continue loop;
            }
            System.out.println(T);
            break;
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob26().run();
    }
}
