import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class michelle {
    public void run() throws FileNotFoundException {
        Scanner file = new Scanner(new File("michelle.dat"));
        int times = file.nextInt();
        file.nextLine();

        for(int ABCD = 1;ABCD<= times;ABCD++) {
            ArrayList<String> words = new ArrayList<>();
            String[] a = file.nextLine().split(" ");
            double numWords = 0;
            while(true) {
                String lna = file.nextLine();
                if (lna.equals("#"))
                    break;
                String[] ln = lna.split(" ");
                for (String s : ln) {
                    words.add(s);
                    numWords++;
                }
            }
            int[] getLens = new int[a.length + 1];
            for (int i = 1; i <= a.length; i++) {
                getLens[i] = Integer.parseInt(a[i - 1]);
            }
            HashMap<Integer, Integer> lens = new HashMap<>();
            for (int i = 0; i < getLens.length; i++) {
                lens.put(getLens[i], 0);
            }
            for (String s : words) {
                for (int i = getLens.length - 1; i >= 0; i--) {
                    if (s.length() > getLens[i]) {
                        lens.put(getLens[i], lens.get(getLens[i]) + 1);
//                        System.out.println(getLens[i]+" "+s);
                        break;
                    }
                }
            }
            System.out.println("Test case #" + ABCD);
            int[] temp = new int[getLens.length + 1];
            for (int i = 0; i < getLens.length; i++) {
                temp[i] = getLens[i];
            }

            temp[temp.length - 1] = 50;
            for (int i = 0; i < temp.length - 1; i++) {
                System.out.printf(
                        "%02d:%02d -> %-2.0f   " +
                        "x".repeat((int)Math.round(lens.get(temp[i])*100/numWords)) +
                        "\n", temp[i] + 1, temp[i + 1], lens.get(temp[i])/numWords*100);
            }
            System.out.println("=".repeat(15));

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new michelle().run();
    }
}