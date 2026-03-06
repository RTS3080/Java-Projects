import java.awt.*;
import java.util.*;
import java.io.*;

public class Inside{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Inside".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int cts=f.nextInt();
            int pts=f.nextInt();
            int[] cornersx = new int[cts];
            int[] cornersy = new int[cts];
            Point[] points = new Point[pts];
            for (int i = 0; i < cts; i++) {
                cornersx[i]=f.nextInt();
                cornersy[i]=f.nextInt();
            }
            for (int i = 0; i < pts; i++) {
                points[i]=new Point(f.nextInt(),f.nextInt());
            }
            Polygon p = new Polygon(cornersx, cornersy, cts);
            for(Point pt : points){
                if(p.contains(pt)){
                    System.out.println("inside");
                }
                else{
                    System.out.println("outside");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Inside().run();
    }
}
