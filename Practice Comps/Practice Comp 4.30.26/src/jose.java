import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jose{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jose".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        HashMap<String, Integer> table = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            table.put(i + "", i);
        }

        for (int i = 0; i < 23; i++) {
            table.put(f.next(), f.nextInt());
        }

        int[] weights = new int[17];

        for (int i = 0; i < 17; i++) {
            f.next();
            weights[i] = f.nextInt();
        }

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String vin = f.next();
            int value = 0;

            for (int i = 0; i < 17; i++) {
                value += table.getOrDefault(vin.charAt(i) + "", 0) * weights[i];
            }

            value %= 11;

            char ch = (char) (value + 48);
            if (value == 10) ch = 'X';
            System.out.println(vin.substring(0, 8) + ch + vin.substring(9));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jose().run();
    }
}
