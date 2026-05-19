import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Dominika{
    class point implements Comparable<point>{
        double x;
        double y;
        public point(double x, double y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(point p){
            if(abs(this.x-p.x)>1E-6){
                return Double.compare(this.x, p.x);
            }
            return Double.compare(this.y, p.y);
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Dominika".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++) {
            point p1 = new point(f.nextDouble(), f.nextDouble());
            point p2 = new point(f.nextDouble(), f.nextDouble());
            double dist = hypot(p1.x - p2.x, p1.y - p2.y);
            final double sq3 = sqrt(3);
            point midPoint = new point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
            double theta = (atan2((p1.y - p2.y) , (p1.x - p2.x)));
            double dx = dist * sq3 / 2 * sin(theta);
            double dy = dist * sq3 / 2 * cos(theta);
            ArrayList<point> points = new ArrayList<>();
            points.add(new point(midPoint.x + dx, midPoint.y - dy));
            points.add(new point(midPoint.x - dx, midPoint.y + dy));
            Collections.sort(points);

            System.out.println("Test case: "+times);
            System.out.println("("+points.get(0).x+","+points.get(0).y+")");
            System.out.println("("+points.get(1).x+","+points.get(1).y+")");
//            System.out.printf("(%.2f,%.2f)\n", points.get(0).x, points.get(0).y);
//            System.out.printf("(%.2f,%.2f)\n", points.get(1).x, points.get(1).y);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Dominika().run();
    }
}
