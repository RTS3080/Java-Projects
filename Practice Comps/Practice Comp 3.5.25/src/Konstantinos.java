import java.util.*;
import java.io.*;

public class Konstantinos{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("Konstantinos".toLowerCase()+".dat"));

        while(in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();

            double dist = distance(x, y, x1, y1);
            if(r + r1 == dist) {
                System.out.println("EXTERNALLY TANGENT");
            }
            else if(r + r1 < dist) {
                System.out.println("NON-INTERSECTING");
            }
            else if(dist + r < r1 || dist + r1 < r) {
                System.out.println("NESTED");
            }
            else if(r == dist + r1 || r1 == dist + r) {
                System.out.println("INTERNALLY TANGENT");
            }
            else {
                System.out.println("INTERSECTING");
            }
        }


//        f.close();
    }

    public double distance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Konstantinos().run();
    }
}
