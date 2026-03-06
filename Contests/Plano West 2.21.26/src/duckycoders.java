import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class duckycoders{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("duckycoders".toLowerCase()+".in"));

        int n = f.nextInt(); f.nextLine();

        long[] ponds = new long[n];
        long[] groups = new long[n];

        for (int i = 0; i < n; i++) {
            ponds[i] = f.nextLong();
        }

        for (int i = 0; i < n; i++) {
            groups[i] = f.nextLong();
        }

        long MOD = (long) (1e9 + 7);

        long min = 0;
        long max = 0;

        Arrays.sort(ponds);
        Arrays.sort(groups);

        for (int i = 0; i < n; i++) {
            min += (ponds[i] % MOD) * (groups[n - i - 1] % MOD) % MOD;
            max += (ponds[i] % MOD) * (groups[i] % MOD) % MOD;
        }

        System.out.println(min % MOD + " " + max % MOD);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new duckycoders().run();
    }
}
