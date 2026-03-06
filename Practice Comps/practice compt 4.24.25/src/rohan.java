import java.awt.*;
import java.util.*;
import java.io.*;

public class rohan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rohan".toLowerCase()+".dat"));
        while(f.hasNext()){

            Point A = new Point(f.nextDouble(), f.nextDouble());
            Point B = new Point(f.nextDouble(), f.nextDouble());
            Point C = new Point(f.nextDouble(), f.nextDouble());
//            f.nextLine();
            double a = B.distance(C);
            double b = C.distance(A);
            double c = B.distance(A);
            double XI = (a * A.x + b*B.x + c*C.x)/(a+b+c);
            double YI = (a * A.y + b*B.y + c*C.y)/(a+b+c);
            double XC = (A.x + B.x + C.x) /3;
            double YC = (A.y + B.y + C.y) /3;
            double perim = (a+b+c)/2;

            double area = Math.sqrt(perim * (perim-a) * (perim-b) * (perim-c));
            System.out.printf("(%.2f,%.2f)\n", XI, YI);
            System.out.printf("(%.2f,%.2f)\n", XC, YC);
            System.out.printf("%.2f\n", area);
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
        double distance(Point p){
            double px = x-p.x;
            double py = y-p.y;
            return Math.sqrt(px*px +py*py );
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new rohan().run();
    }
}
