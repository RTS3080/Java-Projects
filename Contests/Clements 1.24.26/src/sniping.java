import java.util.*;
import java.io.*;
import java.awt.*;

public class sniping{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("sniping".toLowerCase()+".in"));
        Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        int q = f.nextInt();

        TreeSet<Integer> walls = new TreeSet();
        walls.add(Integer.MIN_VALUE);
        walls.add(Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            walls.add(f.nextInt());
        }

        int jacky = 0;

        for (int i = 0; i < q; i++) {
            int action = f.nextInt();

            if (action == 1) {
                walls.add(f.nextInt());
            } else if (action == 2) {
                walls.remove(f.nextInt());
            } else if (action == 3) {
                jacky = f.nextInt();
            } else {
                int piper = f.nextInt();

                if (jacky == piper) {
                    System.out.println("HIT");
                    continue;
                }

                if (jacky < piper) {
                    Integer wall = walls.floor(piper);
                    if (wall == null || wall < jacky) {
                        System.out.println("HIT");
                    } else {
                        System.out.println("MISS");
                    }

                    continue;
                }

                Integer wall = walls.ceiling(piper);
                if (wall == null || wall > jacky) {
                    System.out.println("HIT");
                } else {
                    System.out.println("MISS");
                }
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sniping().run();
    }
}
