import java.util.*;
import java.io.*;

class Time {
    int amt;
    public Time(String s) {
        String[] st = s.split(":");
        amt = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
    }
}

public class Ariel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ariel".toLowerCase()+".dat"));
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] one = f.nextLine().trim().split(" ");
            String[] two = f.nextLine().trim().split(" ");

            Time[] start = new Time[one.length];
            Time[] end = new Time[two.length];

            if (one.length == 1) {
                System.out.println(1);
                continue;
            }

            start[0] = new Time(one[0]);
            end[0] = new Time(two[two.length - 1]);
            int mult = 1;
            for (int i = 1; i < start.length; i++) {
                start[i] = new Time(one[i]);
                end[i] = new Time(two[i - 1]);

                if (start[i].amt < start[i - 1].amt) {
                    mult *= 12;
                }
                start[i].amt *= mult;
                end[i].amt *= mult;
            }


            int max = 1;
            for (int i = 1; i < start.length; i++) {
                int t = 1;
                int j = i;
                while (j > -1 && end[j].amt > start[i].amt) {
                    if (j == 0) {
                        if (start[0].amt < end[end.length - 1].amt) {
                            t--;
                        }
                    }
                    j--;
                    t++;
                }

                max = Math.max(max, t);
            }

            System.out.println(max);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ariel().run();
    }
}
