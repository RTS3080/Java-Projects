import java.util.*;
import java.io.*;
import java.awt.*;

public class mystery{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mystery".toLowerCase()+".in"));

        String test = f.nextLine().toLowerCase();
        String lil = f.nextLine().toLowerCase();

        int[] shifts = new int[lil.length()];
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] = test.charAt(i) - lil.charAt(i);
        }

        int idx = 0;
        String res = "";
        for (int i = 0; i < test.length(); i++) {

            if (test.substring(i, i + 1).matches("[a-z]")) {
                int shift = shifts[idx++ % shifts.length];
                System.out.println((char) ((shift + test.charAt(i) + 26 - 'a') % 26 + 'a'));
            }
            else{
                System.out.println(test.charAt(i));
            }

            System.out.println(shifts[idx % shifts.length]);

        }


//        String line = f.nextLine();
//        String test = f.next();
//        int shift = line.charAt(0) - test.charAt(0);
//        System.out.println(shift);
//        String res = "";
//        for (char ch : line.toLowerCase().toCharArray()) {
//            if (!("" + ch).matches("[a-z]")) {
//                res += ch;
//                continue;
//            }
//
//            res += (char) ((ch - 'a' + 26 + shift) % 26 + 'a');
//        }
//
//        System.out.println((char) (('a' + 26 - 7) % 26 + 'a'));
//
//        System.out.println(res);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mystery().run();
    }
}
