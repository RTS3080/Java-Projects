import java.util.*;
import java.io.*;

public class triangulation{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("triangulation".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<enemy> bad=new ArrayList<>();
            int SpiderX=f.nextInt();
            int SpiderY=f.nextInt();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String n=f.next();
                int x=f.nextInt()-SpiderX;
                int y=f.nextInt()-SpiderY;
                double dist=x*x+y*y;
                bad.add(new enemy(n,dist));
            }
            Collections.sort(bad);
            for(enemy e:bad){
                System.out.print(e.name +" ");
            }
            System.out.println();
        }
        f.close();
    }
}
class enemy implements Comparable<enemy>{
    public double distance;
    public String name;
    public enemy(String n, double d){
        name=n;
        distance=d;
    }
    public int compareTo(enemy e){
        if(distance>e.distance)
            return 1;
        if(distance<e.distance)
            return -1;
        return 0;
    }
}