import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class maxAreaRectangle{

    public int maxRectangleArea(int[][] points) {
        record Point(int x, int y) implements Comparable<Point>{
            public int compareTo(Point p) {
                if(p.x != x){
                    return p.x - x;
                };
                return p.y - y;
            }
        }
        ArrayList<Point> pts = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            pts.add(new Point(points[i][0], points[i][1]));
        }
        HashMap<Point, Integer> map = new HashMap<>();
        Collections.sort(pts);
        ArrayList<Integer> removeInd = new ArrayList<>();
        for(int i = pts.size()-2; i >1; i--){
            Point cur = pts.get(i);
            if(cur.x == pts.get(i-1).x || cur.x == pts.get(i+1).x){
                continue;
            }
            pts.remove(i);
        }

        System.out.println(pts);
        return 0;
    }



    public static void main(String[] args) throws FileNotFoundException{

    }
}
