import java.awt.*;
import java.util.*;
public class erectTheFence {
    public static void main(String[] args) {
        ArrayList<Vector> pts = new ArrayList<>();
        Scanner f = new Scanner(System.in);
        String ln = f.nextLine().trim();
        ln = ln.substring(1, ln.length() - 1);
        String[] points = ln.split("],\\[");
        for(String s : points){
            s = s.replaceAll("[\\[\\]]", "");
            String[] split = s.split(",");
            Vector p = new Vector(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            pts.add(p);
        }
        int[][] trees = new int[pts.size()][2];
        for(int i = 0; i < pts.size(); i++){
            trees[i][0] = pts.get(i).x;
            trees[i][1] = pts.get(i).y;
        }
    }
}
class Solution {
    final static double EPS = 1E-6;
    Vector pivot;
    public int[][] outerTrees(int[][] trees) {
        Vector[] pts = new Vector[trees.length];
        pivot = new Vector(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Vector(trees[i][0], trees[i][1]);
            if(pts[i].y < pivot.y){
                pivot = pts[i];
            }
        }
        for (int i = 0; i < pts.length; i++) {
            pts[i].theta = Math.atan2(pts[i].y-pivot.y, pts[i].x-pivot.x);
            pts[i].dist = Math.hypot(pts[i].x-pivot.x, pts[i].y-pivot.y);
        }
        Arrays.sort(pts);
        for(Vector p : pts){
            System.out.print(p+", ");
        }
        System.out.println();
        Stack<Vector> stack = new Stack<Vector>();
        for (int i = 0; i < 2 && i < pts.length; i++) {
            stack.push(pts[i]);
        }
        for (int i = 2; i < pts.length; i++) {
            Vector a = stack.peek();
            Vector b = stack.get(stack.size()-2);
            Vector cur = pts[i];
            while(!isClockwise(a, b)){
                stack.pop();
                a = stack.peek();
                b = stack.get(stack.size()-2);
            }
            stack.push(cur);
        }

        int[][] out = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++) {
            Vector p = stack.get(i);
            out[i][0] = p.x;
            out[i][1] = p.y;
        }
        return out;
    }
    boolean isClockwise(Vector pointA, Vector pointB){
        if(collinear(pivot, pointA, pointB)){
            return Vector.dist(pivot, pointA) < Vector.dist(pivot, pointB);
        }
        Vector dA = new Vector(-(pivot.x-pointA.x), -(pivot.y-pointA.y));
        Vector dB = new Vector(-(pivot.x-pointB.x), -(pivot.y-pointB.y));
        return (Math.atan2(dA.y, dA.x) - Math.atan2(dB.y, dB.x)) < 0;
    }
    boolean collinear(Vector pivot, Vector a, Vector b){
        Vector dA = new Vector(pivot.x - a.x, pivot.y - a.y);
        Vector dB = new Vector(pivot.x - b.x, pivot.y - b.y);
        double determinant = Math.abs(cross(dA, dB));
        return determinant < EPS;
    }
    double cross(Vector a, Vector b){
        return a.x*b.y - a.y*b.x;
    }

}
class Vector implements Comparable<Vector> {
    int x;
    int y;
    double theta;
    double dist;
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static double dist(Vector a, Vector b) {
        return Math.hypot(b.x - a.x,b.y - a.y);
    }
    public int compareTo(Vector o) {
        if(theta != o.theta){
            return Double.compare(theta, o.theta);
        }
        else{
            return Double.compare(dist, o.dist);
        }
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

