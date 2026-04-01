import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class David{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("David".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        HashMap<Character, Integer> vals = new HashMap<>();
        vals.put('I', 1);
        vals.put('V', 5);
        vals.put('X', 10);
        vals.put('L', 50);
        vals.put('C', 100);
        vals.put('D', 500);
        vals.put('M', 1000);

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            char[] arr = f.nextLine().toCharArray();
            int tot = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int val = vals.get(arr[i]);
                int nextVal = vals.get(arr[i+1]);
                if(val < nextVal) tot-=val;
                else{
                    tot+=val;
                }
            }
            tot+=vals.get(arr[arr.length-1]);
            System.out.println(tot);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new David().run();
    }
}
