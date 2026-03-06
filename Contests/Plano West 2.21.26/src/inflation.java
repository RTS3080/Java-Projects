import java.util.*;
import java.io.*;

public class inflation {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("prob6.dat"));

        double original = f.nextDouble();
        double cumulative = 1.0;

        int bestDay = 1;
        double bestReal = original;

        int day = 1;

        while (f.hasNext()) {
            double inflation = f.nextDouble();
            double price = f.nextDouble();

            day++;
            cumulative *= (1 + inflation);

            double realPrice = price / cumulative;

            if (realPrice < bestReal) {
                bestReal = realPrice;
                bestDay = day;
            }
        }

        System.out.println(bestDay);
        f.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new inflation().run();
    }
}
