import java.util.*;
import java.io.*;

public class armstrongia {

    public static void main(String[] args) throws Exception {
        new armstrongia().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("armstrongia.dat"));
        int cases = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cases; i++) {
            String[] o = in.nextLine().split(" ");
            String name = o[0];
            System.out.println(name + ":");

            double  a = Double.parseDouble(o[1]);
            double b = Double.parseDouble(o[2]);
            double c = Double.parseDouble(o[3]);

            double max = Long.MIN_VALUE;
            int day = 0;

            for (int x = 1; x <= 7; x++) {
                Double pr = a*Math.pow(x,2)+b*x+c;
                System.out.println("Night " + x + ": " + (int)Math.round(pr) + " crimes");

                if(Math.round(pr)>max){
                    max = Math.round(pr);
                    day = x;
                }
            }

            System.out.println("The highest number of crimes is " + (int)Math.round(max) + " on night " + day + ".");
        }
    }
}