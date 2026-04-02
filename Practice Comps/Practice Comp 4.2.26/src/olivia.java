import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class olivia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("olivia".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int rows = f.nextInt();
            int cols = f.nextInt();
            int target = f.nextInt();
            ArrayList<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= Math.sqrt(target); i++){
                if (target % i == 0){
                    factors.add(i);
                    factors.add(target / i);
                }
            }

            Collections.sort(factors);
            int last = 0;
            long result = 0L;
            for (int each : factors){
                if (target / each > rows) continue;
                if (each > cols) break;
                result += (each - last) * (target / each);
                last = each;
            }
            System.out.printf("Case #%d: %d\n", CASE, result);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new olivia().run();
    }
}
