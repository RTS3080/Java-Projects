import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.io.*;

public class dai{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dai".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double[] nums = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            Point[] pts = new Point[nums.length/2];
            Line2D[] lines = new Line2D[pts.length/2];
            for (int i = 0; i < pts.length; i++) {
                pts[i] = new Point(nums[i*2], nums[i*2+1]);
            }
            for (int i = 0; i < lines.length; i++) {
                lines[i] = new Line2D.Double(pts[i*2].x, pts[i*2].y, pts[i*2+1].x, pts[i*2+1].y);
            }
            int intersections = 0;
            for (int i = 0; i < lines.length; i++) {
                for (int j = i; j < lines.length; j++) {
                    if(i == j) continue;
                    if(lines[i].intersectsLine(lines[j])){
                        intersections++;
//                        System.out.println(i+" "+j);
                    }
                }
            }
            System.out.println(intersections);
        }
        f.close();
    }
    class Point{
        double x;
        double y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return x+" "+y;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new dai().run();
    }
}
