import java.util.*;
import java.io.*;
import java.awt.*;

public class mc{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mc".toLowerCase()+".dat"));
        int times=f.nextInt();
        int movements = f.nextInt();
        f.nextLine();
        point[] pts = new point[times+1];

        int count = 1;
        while(times-->0){
            double x = f.nextDouble();
            double y = f.nextDouble();
            pts[count++] = new point(x, y);
        }
//        for(int i=1;i<pts.length;i++){
//            System.out.printf("%.3f %.3f\n", pts[i].x,pts[i].y);
//        }
        loop:
        while(movements-->0){
            int ind = f.nextInt();
            double dx = f.nextDouble();
            double dy = f.nextDouble();
            point p = new point(pts[ind].x + dx, pts[ind].y + dy);

            for (int i = 1; i < pts.length; i++) {
                if(i==ind) continue;
                if(Math.sqrt((p.x-pts[i].x)*(p.x-pts[i].x)+(p.y-pts[i].y)*(p.y-pts[i].y))<=1){
//                    System.out.println("break "+i+" "+ind);
                    continue loop;
                }
            }
            pts[ind] = new point(pts[ind].x + dx, pts[ind].y + dy);
        }
        for(int i=1;i<pts.length;i++){
            System.out.printf("%.3f %.3f\n", pts[i].x,pts[i].y);
        }

        f.close();
    }
    class point{
        double x;
        double y;
        point(double x, double y){
            this.x=x;
            this.y=y;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mc().run();
    }
}
