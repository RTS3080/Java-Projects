import java.util.*;
import java.io.*;

public class rehabilitation{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int n = f.nextInt();
        int k = f.nextInt();

        long[] arr = new long[n];
        long temp = 0;

        for (int i = 0; i < n; i++){
            temp += f.nextInt();
            arr[i] = temp;
        }

        long result = 0;

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                long target = j-i+1;
                long check = arr[j] - (i-1 >= 0 ? arr[i-1] : 0);

                if (target == check) result++;
            }
        }

        System.out.println(result >= k ? "All is well" : "ESCAPE BEFORE THEY REHABILITATE US!!!");

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new rehabilitation().run();
    }
}
