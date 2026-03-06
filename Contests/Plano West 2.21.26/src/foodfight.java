import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class foodfight{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("foodfight".toLowerCase()+".in"));
        int n = f.nextInt();
        int numBuckets = f.nextInt();
        int maxDiff = f.nextInt();
        ArrayList<Integer>ducklings = new ArrayList<>();
        ArrayList<Integer> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ducklings.add(f.nextInt());
        }
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(f.nextInt());
        }
        Collections.sort(ducklings);
        Collections.sort(buckets);
        int count =0;
        loop:
        for (int i = n-1; i>=0;i--) {
            for(int j = buckets.size()-1; j>=0;j--) {
                if(abs(buckets.get(j)-ducklings.get(i))<=maxDiff) {
                    count++;
                    buckets.remove(j);
                    ducklings.remove(i);
                    continue loop;
                }
            }
        }
        System.out.println(count);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new foodfight().run();
    }
}
