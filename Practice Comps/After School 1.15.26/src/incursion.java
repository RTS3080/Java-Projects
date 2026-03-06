import java.util.*;
import java.io.*;
import java.awt.*;

public class incursion{
    class Point {
        double x, y, z;
        double r;
        double v;

        public Point(double x, double y, double z, double r, double v) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.r = r;
            this.v = v;
        }

        public static double getTime(Point origin, Point other) {
            double dist = Math.hypot(origin.x - other.x, origin.y - other.y);
            dist = Math.hypot(dist, origin.z - other.z);
            return (dist - origin.r - other.r) / (origin.v + other.v);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("incursion".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<Point> planets = new ArrayList<>();
            double limit = f.nextDouble();
            int idx = f.nextInt() - 1;

            for (int i = 0; i < 3; i++) {
                planets.add(new Point(f.nextDouble(), f.nextDouble(), f.nextDouble(), f.nextDouble(), f.nextDouble()));
//                if (planets.get(i).v == 0) {
//                    idx = i;
//                }
            }

            Point origin = planets.remove(idx);
            double t1 = Point.getTime(origin, planets.getFirst());
            double t2 = Point.getTime(origin, planets.getLast());

            double time = Math.min(t1, t2);

            if (limit <= time) {
                System.out.printf("Just in time %.2f%n", time);
            } else {
                System.out.printf("Out of time %.2f%n", time);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new incursion().run();
    }
}
