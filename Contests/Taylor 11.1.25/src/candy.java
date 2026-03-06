import java.util.*;
import java.io.*;
import java.awt.*;

public class candy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("candy".toLowerCase()+".in"));
        
        int N = f.nextInt();
        int[] arr = new int[N];

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = f.nextInt();
            sum += arr[i];
        }

        int target = sum >> 1;

        int result = Integer.MAX_VALUE;

        int startSum = 0;

        for (int start = 0; start <= N; start++) {
            startSum += start-1 >= 0 ? arr[start-1] : 0;
            int endSum = 0;

            for (int end = N-1; end >= start; end--) {
                endSum += arr[end];
                if (startSum + endSum == target){
                    result = Math.min(result, start + (N-end));
                }
            }
        }

        System.out.println(result);
        
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new candy().run();
    }
}
