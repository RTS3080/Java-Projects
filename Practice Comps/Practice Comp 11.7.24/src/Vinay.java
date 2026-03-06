import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Vinay{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vinay".toLowerCase()+".dat"));
        int tcs = f.nextInt();
        f.nextLine();
        for (int cses = 0; cses < tcs; cses++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            String orig = f.nextLine();
            String line = new String(orig);
            line = line.toLowerCase();
            line = line.replaceAll("[^a-zA-Z0-9]", "");
            //System.out.println(line);
            for (char c : line.toCharArray()) {
                hm.put(c, hm.getOrDefault(c, 0) + 1);
            }
            int len = 0;
            int pivots = 0;
            for (char c : hm.keySet()) {
                if (hm.get(c) % 2 == 1)
                    pivots++;
                len += hm.get(c) / 2;
            }
//            System.out.println(line+" "+len+" "+pivots);
            if (line.length() % 2 == 0 && pivots > 0)
                System.out.println(orig+" can not be rearranged to form a palindrome.");
            else if (line.length() % 2 == 1 && pivots > 1)
                System.out.println(orig+" can not be rearranged to form a palindrome.");
            else{
                BigInteger fac = BigInteger.ONE;
                for (int i = 1; i <= len ; i++) {
                    fac = fac.multiply(BigInteger.valueOf(i));
                }
                for (char c : hm.keySet()) {
                    BigInteger facDiv = BigInteger.ONE;
                    for (int i = 1; i <= hm.get(c)/2 ; i++) {
                        facDiv = facDiv.multiply(BigInteger.valueOf(i));
                    }
                    fac = fac.divide(facDiv);
                }
                System.out.println(orig+" can be rearranged to form "+fac+" distinct palindrome(s).");;
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Vinay().run();
    }
}
