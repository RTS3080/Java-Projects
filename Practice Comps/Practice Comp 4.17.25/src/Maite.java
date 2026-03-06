import java.util.*;
import java.io.*;

public class Maite{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Maite".toLowerCase()+".dat"));
        int ts = f.nextInt();
        for(int i=1; i<=ts; i++){
            int n = f.nextInt();
            int k = f.nextInt();
            int[] d = new int[n];
            for(int j=0; j<n; j++){
                d[j] = f.nextInt();
            }

            HashMap<Integer,Integer> counts = new HashMap<>();
            int l = 0;
            int inv = 0;
            for(int j=0; j<n; j++){
                counts.put(d[j],counts.getOrDefault(d[j],0) + 1);
                if (counts.get(d[j]) == k+1){
                    inv++;
                }

                if (inv > 0){
                    counts.put(d[l],counts.getOrDefault(d[l],0) - 1);
                    if (counts.get(d[l]) == k){
                        inv--;
                    }
                    l++;
                }
            }

            System.out.println("Case #"+i+": "+(n-l));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Maite().run();
    }
}

