import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sanjay{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sanjay".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numPolygons = f.nextInt();
            double x0 = f.nextDouble(), y0 = f.nextDouble(), dx = f.nextDouble(), dy = f.nextDouble();
            double slope = getSlope(dx,dy,0,0);
            double[][][] polygons = new double[numPolygons][][];
            for (int i = 0; i < numPolygons; i++) {
                int numPts = f.nextInt();
                polygons[i] = new double[numPts+1][2];
                for (int j = 0; j < numPts; j++) {
                    polygons[i][j][0] = f.nextDouble();
                    polygons[i][j][1] = f.nextDouble();
                }
                polygons[i][numPts][0] = polygons[i][0][0];
                polygons[i][numPts][1] = polygons[i][0][1];
            }
            double dist = Integer.MAX_VALUE;
            for(double[][] polygon : polygons){
                if(lineIntersectsPolygon(polygon, x0,y0,slope)){
                    dist = 0;
                    break;
                }
                for(double[] pt : polygon){
                    double x1 = pt[0];
                    double y1 = pt[1];
                    double x = (x1/slope + slope * x0 + y1 - y0)/ (slope + 1/slope);
                    double y = slope * x - slope*x0 + y0;
                    dist  =Math.min(dist, Math.hypot(x1-x,y1-y));
                }
            }
            System.out.printf("%.3f\n", dist);
        }
        f.close();
    }
    double[] getIntersection(double x1, double y1, double slope1, double x2, double y2, double slope2){
        double x = (slope1 * x1 - slope2*x2 - y1+y2)/(slope1-slope2);
        double y = slope1 * (x - x1) + y1;
        return new double[]{x,y};
    }
    boolean isBetween2Pts(double x1, double y1, double x2, double y2, double x3, double y3){
        double slope = getSlope(x1,y1,x2,y2);
        double predictedY = slope * (x3-x1) + y1;
        return abs(y3-predictedY) <= 1E-6;
    }
    boolean lineIntersectsPolygon(double[][] polygon, double x0, double y0, double slope0){
        for (int i = 0; i < polygon.length-1; i++) {
            double slope = getSlope(polygon[i][0],polygon[i][1], polygon[i+1][0], polygon[i+1][1]);
            double[] intersection = getIntersection(polygon[i][0], polygon[i][1], slope, x0, y0, slope0);
            if(isBetween2Pts(polygon[i][0], polygon[i][1], polygon[i+1][0], polygon[i+1][1], x0, y0)){return true;}
        }
        return false;
    }
    double getSlope(double x1, double y1, double x2, double y2){
        if(y1-y2 == 0) return 1E-10;
        if(x2-x1==0) return 1E10;
        return (y2-y1)/(x2-x1);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new sanjay().run();
    }
}
