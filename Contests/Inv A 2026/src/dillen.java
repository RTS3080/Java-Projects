import java.util.*;
import java.io.*;
import java.awt.*;

public class dillen{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dillen".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int limit = f.nextInt();
            int speed = f.nextInt();

            boolean schoolZone = f.next().equals("Y");
            boolean workZone = f.next().equals("Y");
            boolean workers = workZone & f.next().equals("Y");

            int demerit = 0;
            int fine = 0;

            int diff = speed - limit;
            if (diff <= 0) {}
            else if (diff < 10) {
                fine = 60;
                demerit = 1;
            } else if (diff < 20) {
                fine = 120;
                demerit = 2;
            } else if (diff < 30) {
                fine = 240;
                demerit = 3;
            } else {
                fine = 500;
                demerit = 4;
            }

            if (speed >= 100) {
                fine += 200;
            }

            if (schoolZone) {
                fine *= 2;
                demerit++;
            }

            if (workers) {
                fine *= 3;
                demerit++;
            } else if (workZone) {
                fine *= 2;
            }

            if (fine > 1000) {
                fine += 150;
            }

            boolean suspended = demerit >= 6;

            if (suspended) {
                System.out.println("License suspended");
            } else if (diff <= 0) {
                System.out.println("No ticket");
            } else {
                System.out.println("$" + fine);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dillen().run();
    }
}
