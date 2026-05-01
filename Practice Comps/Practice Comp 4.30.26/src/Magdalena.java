import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

import static java.lang.Math.*;


public class Magdalena{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Magdalena".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        chars = new ArrayList<>();
        String use = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (char each : use.toCharArray()) chars.add(each);

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int base = f.nextInt();
            String digit = f.next();

            int[] digitSums = new int[digit.length()];
            digitSums[0] = chars.indexOf(digit.charAt(0));

            for (int i = 1; i < digit.length(); i++) digitSums[i] = digitSums[i-1] + chars.indexOf(digit.charAt(i));
            int maxSum = digitSums[digit.length()-1];

            for (int i = digit.length()-1; i >= 0; i--){
                int temp = 0;
                if (i-1 >= 0) temp += digitSums[i-1];
                int digitVal = chars.indexOf(digit.charAt(i));
                if (digitVal >= 1){
                    temp += digitVal-1;
                    temp += (digit.length()-i-1) * (base-1);
                }

                maxSum = Math.max(maxSum, temp);
            }

//            System.out.println(maxSum);
            System.out.printf("Case #%d: %s\n", CASE, convert(maxSum, base));

        }
        f.close();
    }

    ArrayList<Character> chars;

    public String convert(int check, int base){
        String res = "";
        while (check > 0){
            int mod = check%base;
            res = chars.get(mod) + res;
            check /= base;
        }

        if (res.isEmpty()) res = "0";
        return res;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Magdalena().run();
    }
}
