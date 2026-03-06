import java.awt.geom.Line2D;
import java.util.*;
import java.io.*;
import java.awt.*;

public class delfina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("delfina".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int times2=f.nextInt(); f.nextLine();
            Line2D[] lines = new Line2D[times2];
            int x1 = f.nextInt(); int y1 = f.nextInt();
            for (int i = 0; i < times2-1; i++) {
                int x2 = f.nextInt(); int y2 = f.nextInt();
                lines[i] = new Line2D.Double(x1, y1, x2, y2);
                x1 = x2;
                y1 = y2;
            }
            lines[times2-1] = new Line2D.Double(x1,y1, lines[0].getX1(), lines[0].getY1());
//            System.out.println(Arrays.toString(lines));
//            for(Line2D line: lines){
//                System.out.println(line.getX1()+" "+line.getY1()+", "+line.getX2()+" "+line.getY2());
//            }
            boolean intersect = false;
            for (int i = 0; i < times2; i++) {
                for (int j = 0; j < times2; j++) {
                    if(i == j || i == j+1 || i == j-1) continue;
                    if(i == 0 && j == times2-1 || j == 0 && i == times2-1 )continue;
                    if(lines[i].intersectsLine(lines[j])){
                        intersect = true;
//                        System.out.println("bad ("+lines[i].getX1()+" "+lines[i].getY1()+") ("+lines[i].getX2()+" "+lines[i].getY2()+") : ("+
//                                lines[j].getX1()+" "+lines[j].getY1()+") ("+lines[j].getX2()+" "+lines[j].getY2()+")");
                    }
                }
            }
            System.out.println(intersect?"Self intersecting" : "Simple");
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new delfina().run();
    }
}
