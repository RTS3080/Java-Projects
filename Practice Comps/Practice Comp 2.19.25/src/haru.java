import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class haru{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("haru".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();

        timeloop:
        while(times-->0){
            f.nextInt();
            int x1 = f.nextInt();
            int y1 = f.nextInt();
            char[] one = f.next().trim().toCharArray();
            int x2 = f.nextInt();
            int y2 = f.nextInt();
            char[] two = f.next().trim().toCharArray();

            HashSet<String> vis = new HashSet<>();
            boolean flag = true;

            for (int i = 0; i <= one.length; i++) {
                if (x1 == x2 && y1 == y2) {
                    flag = false;
                    System.out.println("HEAD ON");
                    break;
                }

                boolean oneHit = x1 < 0 || x1 > 100 || y1 < 0 || y1 > 100 || vis.contains(x1 + " "+ y1);
                boolean twoHit = x2 < 0 || x2 > 100 || y2 < 0 || y2 > 100 || vis.contains(x2 + " " + y2);
                if (oneHit && twoHit) {
                    System.out.println("DOUBLE SPIKE");
                    flag = false;
                    break;
                }

                if (oneHit) {
                    System.out.println("P2 WIN");
                    flag = false;
                    break;
                }

                if (twoHit) {
                    System.out.println("P1 WIN");
                    flag = false;
                    break;
                }

                String p1 = x1 + " " + y1;
                String p2 = x2 + " " + y2;

                vis.add(x1 + " " + y1);
                vis.add(x2 + " " + y2);

                if (i == one.length) continue;
                switch (one[i]) {
                    case 'L' -> x1--;
                    case 'R' -> x1++;
                    case 'D' -> y1--;
                    case 'U' -> y1++;
                }

                switch (two[i]) {
                    case 'L' -> x2--;
                    case 'R' -> x2++;
                    case 'D' -> y2--;
                    case 'U' -> y2++;
                }

                if ((x1 + " " + y1).equals(p2) && (x2 + " " + y2).equals(p1)) {
                    System.out.println("HEAD ON");
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.println("DRAW");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new haru().run();
    }
}
