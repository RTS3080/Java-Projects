import java.util.*;
import java.io.*;

public class prob07{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            counts.put(i, -1);
        }
        String s = f.nextLine();
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            counts.put(n, counts.get(n)+1);
        }
//        System.out.println(counts);
        int min = -1;
        int minCount = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(entry.getValue() < minCount && entry.getValue() !=-1){
                minCount = entry.getValue();
                min = entry.getKey();
            }
        }
        System.out.println(min+": "+minCount);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob07().run();
    }
}
