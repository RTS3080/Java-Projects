import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class reka{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("reka".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            long len = f.nextLong();
            int numClues = f.nextInt();
            HashMap<Long, Character> map = new HashMap<>();

            boolean impossible = false;

            for (int i = 0; i < numClues; i++){
                long ind = f.nextLong()-1;
                char ch = f.next().charAt(0);

                long reflected = Math.abs(len-1-ind);
                long check = Math.min(ind, reflected);

//                System.out.println(map);

                if (map.containsKey(check)){
                    if (map.get(check) != ch) impossible = true;
                }
                else map.put(check, ch);
            }

//            System.out.println(map);

            long res = 0;
            boolean padZeros = false;
            if (!impossible){
                long numPow = (len+1)/2 - map.size();

                if (numPow > 6) padZeros = true;
                res = recur(26, numPow);
            }
            System.out.printf("Case #%d: %"+(padZeros?"09":"")+"d\n", CASE, res);
        }

//        for (int i = 0; i < 1000; i++){
//            boolean padZeros = false;
//
//            if (i > 6) padZeros = true;
//
//            System.out.printf("Case #%d: %"+(padZeros?"09":"")+"d\n", i, recur(26, i));
//        }


//        long res = 1;
//        for (int i = 1; i < 26; i++){
//            res *= 26;
//            System.out.println(res);
//        }

        f.close();
    }

    long recur(int base, long pow){
        if (pow == 0) return 1;
        if (pow == 1) return base;

        long res = 1;

        long temp = recur(base, pow/2);

        res = temp;
        res *= temp;
        res %= 1e9;

        if (pow % 2 == 1){
            res *= 26;
            res %= 1e9;
        }

        return res;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new reka().run();
    }
}
