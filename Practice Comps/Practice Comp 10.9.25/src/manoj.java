import java.util.*;
import java.io.*;
import java.awt.*;

public class manoj{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("manoj".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int MF = f.nextInt();
            int MB = f.nextInt();
            int degree = f.nextInt();

            char convertFrom = f.next().charAt(0);
            char convertTo = f.next().charAt(0);

            int x1 = -1, y1 = -1, x2 = -1, y2 = -1, x = degree;

            if (convertFrom == 'M') {
                x1 = MF;
                x2 = MB;
            } else if (convertFrom == 'C') {
                x1 = 0;
                x2 = 100;
            } else {
                x1 = 32;
                x2 = 212;
            }

            if (convertTo == 'M') {
                y1 = MF;
                y2 = MB;
            } else if (convertTo == 'C') {
                y1 = 0;
                y2 = 100;
            } else {
                y1 = 32;
                y2 = 212;
            }

            double m = ((double)y2 - y1) / (x2 - x1);
            int y = (int)Math.round(m * (x - x1) + y1);
            System.out.printf("%d degrees %s = %d degrees %s%n", x, convertFrom, y, convertTo);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new manoj().run();
    }
}
