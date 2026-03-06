import java.util.*;
import java.io.*;

public class veda{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("veda".toLowerCase()+".dat"));

        HashMap<Character, Double> costs = new HashMap<>();
        int maps = f.nextInt();
        f.nextLine();
        for (int i = 0; i < maps; i++) {
            String[] line = f.nextLine().trim().split(":");
            String letters = line[0].replace(",", "");
            double cost = Double.parseDouble(line[1]);

            for (char c : letters.toCharArray()) {
                costs.put(c, cost);
            }
        }

        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String line = f.nextLine().replaceAll("\\W", "");
            double total = 0;

            for (char c : line.toCharArray()) {
                total += costs.get(c);
            }

            System.out.printf("$%.2f\n", total);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new veda().run();
    }
}
