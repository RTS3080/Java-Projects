import java.util.*;
import java.io.*;

public class fibonacci{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fibonacci".toLowerCase()+".dat"));

        long[] calls = new long[51];
        calls[0] = 1;
        calls[1] = 1;
        for (int i = 2; i < calls.length; i++){
            calls[i] = calls[i-1] + calls[i-2]+1;
        }

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();

            if (N == 0 || N == 1){
                System.out.println(0);
                continue;
            }

            long result = calls[N];
            for (int i = 1; i <= N-2; i++){
                result -= calls[i];
            }
            System.out.println(calls[N]-result);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fibonacci().run();
    }
}
