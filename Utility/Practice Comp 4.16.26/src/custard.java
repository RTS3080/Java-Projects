import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class custard{


    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("custard".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int groups = f.nextInt();
            long max = f.nextLong();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = f.nextInt();
            }
            int sum = 0;
            ArrayList<Integer> sums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(sum + arr[i] > max){
                    sums.add(sum);
                    sum = 0;
                }
                sum+=arr[i];
            }
            if(sum > 0){
                sums.add(sum);
            }
            while(sums.size() > groups){
                if(sums.getFirst() + sums.getLast() <= max){
                    sums.set(0, sums.getFirst() + sums.getLast());
                    sums.removeLast();
                }
                else break;
            }

//            System.out.println(sums);
            if (sums.size() <= groups) {
                System.out.println("Connie's Custard acquired.");
            } else {
                System.out.println("Mission Failed. We'll get them next time.");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new custard().run();
    }
}
