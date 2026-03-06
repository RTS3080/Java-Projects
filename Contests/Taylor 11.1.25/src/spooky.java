import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;
import java.awt.*;

public class spooky{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spookyBriefcases".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        double minx= Integer.MAX_VALUE;
        double miny= Integer.MAX_VALUE;
        double maxx= Integer.MIN_VALUE;
        double maxy= Integer.MIN_VALUE;
        int spookyCount = 0;
        ArrayList<mass> cnt = new ArrayList<>();
        while(times-->0){
            double mass = f.nextDouble();
            double x= f.nextDouble();
            double y= f.nextDouble();
            minx = Math.min(minx, x);
            miny = Math.min(miny, y);
            maxx = Math.max(maxx, x);
            maxy = Math.max(maxy, y);
            String status = f.next();
            cnt.add(new mass(x,y,mass,status));
            if(status.equals("SPOOKY")){
                spookyCount++;
            }
        }
        for(mass mass: cnt){
            if(mass.status.equals("SPOOKY")){
                mass.mass = mass.mass*mass.mass*(spookyCount-1);
            }
        }
        double xcm = 0;
        double ycm = 0;
        double totMass = 0;
        for(mass mass: cnt){
            totMass+=mass.mass;
            xcm+=mass.x*mass.mass;
            ycm+=mass.y*mass.mass;
        }
//        System.out.println(cnt);
        xcm/=totMass;
        ycm/=totMass;
        System.out.printf("(%.4f, %.4f)\n",xcm,ycm);
        String out = "";
        if(xcm>maxx || ycm>maxy || xcm<minx || ycm<miny){
            out = "HAUNTED!";
        }
        else out = "NORMAL!";
        System.out.println(out);
        f.close();
    }
    class mass{
        double x;
        double y;
        double mass;
        String status;
        public mass(double x, double y, double mass, String status){
            this.x=x;
            this.y=y;
            this.mass=mass;
            this.status=status;
        }
        public String toString(){
            return x+","+y+","+mass+","+status;
        }

    }


    public static void main(String[] args) throws FileNotFoundException{
        new spooky().run();
    }
}
