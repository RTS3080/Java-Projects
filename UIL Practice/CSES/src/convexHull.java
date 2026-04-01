import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class convexHull{

    class point{
        int x;
        int y;
        double dist;
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "[("+x+" , "+y+String.format(") : %.2f]", dist);
        }

    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        point[] pts = new point[numTimes];
        point leftPoint = new point(Integer.MAX_VALUE,0);
        for (int i = 0; i < numTimes; i++) {
            int x= f.nextInt();
            int y= f.nextInt();
            pts[i] = new point(x, y);
            if(x < leftPoint.x){
                leftPoint = new point(x, y);
            }
        }
        for (int i = 0; i < pts.length; i++) {
            pts[i].dist = hypot(pts[i].x-leftPoint.x,pts[i].y-leftPoint.y);
        }
        ArrayList<point> top = new ArrayList<>();
        ArrayList<point> bottom = new ArrayList<>();
        for (int i = 0; i < pts.length; i++) {
            if(pts[i].y >= leftPoint.y){
                top.add(pts[i]);
            }
            else bottom.add(pts[i]);
        }
        bottom.add(leftPoint);
        Collections.sort(top, (point a, point b)->{
            if(a.dist != b.dist){
                return Double.compare(a.dist, b.dist);
            }
            return Integer.compare(a.y, b.y);
        });
        Collections.sort(bottom, (point a, point b)->{
            if(a.dist != b.dist){
                return -Double.compare(a.dist, b.dist);
            }
            return -Integer.compare(a.y, b.y);
        });
        System.out.println(top);
        System.out.println(bottom);
        f.close();
    }
/*
6
2 3
2 1
2 5
3 3
4 3
4 4
6 3
 */


    public static void main(String[] args) throws FileNotFoundException{
        new convexHull().run();
    }
}
