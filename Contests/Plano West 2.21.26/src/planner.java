import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class planner{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob26".toLowerCase()+".dat"));
//        Scanner f = new Scanner(System.in);

        int N = f.nextInt();
        int numDistinct = f.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = f.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        int result = 0;
        int left = 0;
        int right = 0;

        while (left < arr.length){
            right_loop:
            while (right < arr.length){
                int cur = arr[right];
                if (!map.containsKey(cur)) {
                    if (map.size() == numDistinct) break right_loop;

                    map.put(cur,0);
                }
                map.put(cur,map.get(cur)+1);
                right++;
            }

            result = Math.max(result,right-left);
            int cur = arr[left];
            map.put(cur,map.get(cur)-1);
            if (map.get(cur) == 0) map.remove(cur);
            left++;
        }

        System.out.println(result);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new planner().run();
    }
}
