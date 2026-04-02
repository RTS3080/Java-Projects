import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class mahesh{
    public int get(String s, int...bits) {
        int sum = 0;
        for (int bit : bits) {
            sum += s.charAt(bit - 1) - '0';
        } return sum;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mahesh".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int num = f.nextInt();

            String hamming = Integer.toBinaryString(num);
            if (hamming.length() > 11) {
                hamming = hamming.substring(hamming.length() - 11);
            }
            hamming = String.format("%11s", hamming).replace(" ", "0");

            int one = get(hamming, 3, 5, 7, 9, 11) % 2;
            int two = get(hamming, 3, 6, 7, 10, 11) % 2;
            int four = get(hamming, 5, 6, 7) % 2;
            int eight = get(hamming, 9, 10, 11) % 2;

            int error = 0;

            if (one != get(hamming, 1)) {
                error++;
            }

            if (two != get(hamming, 2)) {
                error += 2;
            }

            if (four != get(hamming, 4)) {
                error += 4;
            }

            if (eight != get(hamming, 8)) {
                error += 8;
            }

            if (error != 0) {
                if (hamming.charAt(error - 1) == '0') {
                    hamming = hamming.substring(0, error  - 1) + "1" + hamming.substring(error);
                } else {
                    hamming = hamming.substring(0, error - 1) + "0" + hamming.substring(error);
                }
            }

            String bits = hamming.substring(2, 3) + hamming.substring(4, 7) + hamming.substring(8);
            char ch = (char) Integer.parseInt(bits, 2);
            System.out.print(ch);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mahesh().run();
    }
}
