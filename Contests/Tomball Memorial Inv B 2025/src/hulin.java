import java.util.*;
import java.io.*;

public class hulin{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hulin".toLowerCase()+".dat"));
        int[] buckets = new int[86400];

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            for (int i = 0; i < 3; i++) {
                int start = f.nextInt() - 1;
                int end = f.nextInt();

                for (int j = start; j < end; j++) {
                    buckets[j]++;
                }
            }
        }

        int max = 0;
        for (int bucket : buckets) {
            max = Math.max(max, bucket);
        }

        System.out.println(max);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hulin().run();
    }
}
