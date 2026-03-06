import java.util.*;
import java.io.*;

public class lights{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("lights".toLowerCase()+".dat"));

        int times = f.nextInt();

        while (times-- > 0) {
            char[] tmp = f.next().toCharArray();
            boolean[] bulbs = new boolean[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                bulbs[i] = tmp[i] == '1';
            }
            int cases = f.nextInt();
            f.nextLine();
            for (int i = 0; i < cases; i++) {
                String action = f.next();
                String range = f.nextLine().trim();
                int start = 0;
                int end = bulbs.length;
                if (range.matches("\\d+ \\d+")) {
                    String[] t = range.split(" ");
                    start = Integer.parseInt(t[0]);
                    end = Integer.parseInt(t[1]);
                }

                for (int j = start; j < end; j++) {
                    if (action.equals("FLIP")) {
                        bulbs[j] = !bulbs[j];
                    } else bulbs[j] = action.equals("ON");
                }

            }
            for (int j = 0; j < bulbs.length; j++) {
                System.out.print(bulbs[j] ? '1' : '0');
            }
            System.out.println();
        }

        f.close();
    }
}
