package Solutions;

import java.util.*;
import java.io.*;
public class Calvin {
    public static void main(String[] args) throws Exception {
        Scanner f = new Scanner(new File("calvin.dat"));
        int times = f.nextInt();
        while(times-->0){
            int month = f.nextInt(); // Calendar months are 0-based


            int year = f.nextInt();


            Calendar calendar = new GregorianCalendar(year, month-1, 1);


            System.out.println(" ".repeat(6) + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);
            System.out.println("Su Mo Tu We Th Fr Sa");


            int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


            for (int i = 1; i < firstDayOfWeek; i++) {
                System.out.print("   ");
            }


            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%2d ", day);

                if ((day + firstDayOfWeek - 1) % 7 == 0 && day != daysInMonth) {
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println("-".repeat(20));
        }



        f.close();
    }
}