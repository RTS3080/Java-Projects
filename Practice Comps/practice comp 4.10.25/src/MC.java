import java.awt.*;
import java.util.*;
import java.io.*;

public class MC{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("MC".toLowerCase()+".dat"));
        int times=f.nextInt(), moves = f.nextInt();
        point[] pts = new point[times+1];
        f.nextLine();
        for (int i = 1; i <= times; i++) {
            pts[i] = new point(f.nextDouble(), f.nextDouble());
        }
        while(moves-->0){
            int ind = f.nextInt();
            double moveX = f.nextDouble(), moveY = f.nextDouble();
            pts[ind].x += moveX;
            pts[ind].y += moveY;
            boolean b = true;
            for (int i = 1; i < pts.length; i++) {
                if(pts[ind].equals(pts[i]) && i != ind){
                    b = false;
                }
            }
            if(!b){
                pts[ind].x-=moveX;
                pts[ind].y -=moveY;
            }
        }
        for(int i = 1; i< pts.length; i++){
            point p = pts[i];
            System.out.printf("%.3f %.3f\n", p.x, p.y);
        }
        f.close();
    }

    class point{
        double x,y;
        point(double x, double y){
            this.x=x;
            this.y=y;
        }
        point(point p){
            this.x=p.x;
            this.y=p.y;
        }
        public boolean equals(point p){
            return distance(p,this)<1;
        }
    }
    public double distance(point p1, point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x, 2)+ Math.pow(p1.y-p2.y, 2));
    }



    public static void main(String[] args) throws FileNotFoundException{
        new MC().run();
    }
}
