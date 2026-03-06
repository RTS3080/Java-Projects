import java.util.*;
import java.io.*;

public class star{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("I.txt"));
        int times=f.nextInt(); f.nextLine();
        for(int abc = 1; abc <= times; abc++){
            System.out.print("Star "+abc+": ");
            double r = f.nextDouble()/2;
            int pts = f.nextInt();
            int inc = f.nextInt();
            point[] points = new point[pts];
            double degInc = Math.PI * 2 / pts;
            for (int i = 0; i < pts; i++) {
                points[i] = new point(r * Math.cos(degInc*i), r * Math.sin(degInc*i));
            }
            int prevInd = 0;
            int Ind= inc;
            double totDist = 0;
            while(Ind !=0){
                totDist +=distance(points[prevInd], points[Ind]);
                prevInd = Ind;
                Ind  = (Ind + inc)%pts;
            }
            totDist += distance(points[prevInd], points[Ind]);
            System.out.printf("%.2f\n", totDist);
        }
        f.close();
    }
    public double distance(point p1, point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x, 2)+ Math.pow(p1.y-p2.y, 2));
    }

    class point{
        double x,y;
        point(double x, double y){
            this.x=x;
            this.y=y;
        }
        public boolean equals(point p){
            return distance(p,this)<1;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new star().run();
    }
}
