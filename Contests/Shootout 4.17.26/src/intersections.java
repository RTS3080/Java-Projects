import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class intersections{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("intersections".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        record segment(int x1, int y1, int x2, int y2){
            public String toString(){
                return "("+x1+","+y1+")->("+x2+","+y2+")";
            }
        }
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int times2=f.nextInt(); f.nextLine();
            segment[] segments = new segment[times2];
            for (int i = 0; i < times2; i++) {
                int x1=f.nextInt();
                int y1=f.nextInt();
                int x2=f.nextInt();
                int y2=f.nextInt();
                segments[i]=new segment(x1,y1,x2,y2);
            }


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new intersections().run();
    }
}
