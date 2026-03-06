import java.util.*;
import java.io.*;

public class communicationNetwork{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int n = f.nextInt();
        long[] xs = new long[n];
        long[] ys = new long[n];

        for(int i = 0; i < n; i++){
            xs[i] = f.nextLong();
            ys[i] = f.nextLong();
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        long xMedian = n%2 == 1 ? xs[n/2] : (xs[n/2-1]+xs[n/2])/2;
        long yMedian = n%2 == 1 ? ys[n/2] : (ys[n/2-1]+ys[n/2])/2;

        long result = 0;
        for (int i = 0; i < n; i++){
            result += Math.abs(xs[i] - xMedian);
            result += Math.abs(ys[i] - yMedian);
        }

        System.out.println(result);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new communicationNetwork().run();
    }
}
