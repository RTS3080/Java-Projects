import java.util.*;
import java.io.*;
import java.awt.*;

public class brewingbottleneck{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("brewingbottleneck".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int numStands = f.nextInt();
            int target = f.nextInt();

            int minTime = Integer.MAX_VALUE;
            int[] stands = new int[numStands];
            for (int i = 0; i < numStands; i++){
                stands[i] = f.nextInt();
                minTime = Math.min(minTime, stands[i]);
            }

            long low = 0;
            long high = (long) (minTime) * target + 1000;

            while (low < high){
                long mid = (low + high)/2;

                long check = 0;
                for (int each:stands){
                    check += mid/each;
                }

                if (check < target) low = mid+1;
                else high = mid;
            }

            System.out.println(low);



//            PriorityQueue<Integer> q = new PriorityQueue<>();
//            for (int i = 0; i < brewingStands; i++) {
//                q.add(f.nextInt());
//            }
//
//            int res = 0;
//            int last = 0;
//            for (int i = 0; i < pots; i++) {
//                System.out.println(q);
//                int t = q.poll();
//                res += t;
//                q.add(res);
//                last = res;
//            }
//            System.out.println(last);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new brewingbottleneck().run();
    }
}
