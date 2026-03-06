import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class shipping {
    public String getTime(int min) {
        int hours = min / 60;
        min %= 60;
        boolean am = hours < 12;
        hours %= 12;
        if (hours == 0) hours = 12;
        return String.format("%d:%02d%s", hours, min, am ? "AM" : "PM");
    }

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("shipping".toLowerCase() + ".in"));

        int times = f.nextInt();
        f.nextLine();
        int day = 0;
        while (times-- > 0) {
            day++;

            int time = 240;

            System.out.println("Day #" + day);

            int days = f.nextInt();
            f.nextLine();
            while (days-- > 0) {
                String city = f.next();
                int widgets = (f.nextInt() + 8) / 9 * 9;
                if (time + widgets * 5 > 20 * 60) {
                    System.out.println(city + " does not get a shipment today.");
                    time += widgets * 5;
                    continue;
                }
                time += widgets * 5;
                System.out.println("Ship " + widgets / 9 + " cases to " + city + " at " + getTime(time) + ".");
            }
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new shipping().run();
    }
}
