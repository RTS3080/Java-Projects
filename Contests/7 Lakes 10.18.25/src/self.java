import java.awt.*;
import java.util.*;
import java.io.*;

public class self{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt();
        int times2 = f.nextInt();f.nextLine();
        ArrayList<point> pts = new ArrayList<>();
        while(times-->0){
            String dir = f.next();
            int  x= f.nextInt();
            int  y= f.nextInt();
            int dx = 0;
            int dy = 0;
            if(dir.equals("W")){
                dx = -1;
            }
            else{
                dy = -1;
            }
            pts.add(new point(x,y,dx,dy));
        }
//        System.out.println(pts);

        ArrayList<occ> collisions = new ArrayList<>();
        for (int i = 0; i < pts.size(); i++) {
            point p = pts.get(i);
            for (int j = 0; j < pts.size(); j++) {
                point  a= pts.get(j);
//                System.out.println(p+" "+a);
                if(p.dx==a.dx){
//                    System.out.println("what");
                    continue;
                }
                else{
                    if((p.x-a.x)-(a.y-p.y)==0){
                        collisions.add(new occ(p,a,(Math.abs(p.x-a.x))));
                    }
                }
            }
        }
        int maxTime = f.nextInt();
        Collections.sort(collisions);
        while (times2-->0) {
            HashSet<point> collided = new HashSet<>();

            ArrayList<occ> collisions2 = new ArrayList<>();
            for(occ o : collisions) collisions2.add(o);

            int result = 0;
//            System.out.println(collisions);
            for (occ o : collisions) {
//                System.out.println(o);
                if (collided.contains(o.p1) || collided.contains(o.p2)) {
//                    System.out.println("hello");
                    continue;
                }

                if (o.t > maxTime) {
//                    System.out.println("hello2");
                    break;
                }
                collided.add(o.p1);
                collided.add(o.p2);
//                System.out.println(o.p1 + " " + o.p2);
                result++;
            }
//            System.out.println(collided);

            System.out.println(result);
        }
        f.close();
    }
    class point{
        int x,y;
        int dx, dy;
        public point(int x,int y,int dx,int dy){
            this.x=x;
            this.y=y;
            this.dx=dx;
            this.dy=dy;
        }

        public int hashCode(){
            return Objects.hash(x,y,dx,dy);
        }
        public String toString(){
            return x+","+y+","+dx+","+dy;
        }
    }
    class occ implements Comparable<occ>{
        point p1;
        point p2;
        int t;
        public occ(point p1, point p2,int t){
            this.p1=p1;
            this.p2=p2;
            this.t=t;
        }
        public int compareTo(occ o) {
            return this.t-o.t;
        }
        public String toString(){
            return p1.toString()+"\n"+p2.toString()+"\n"+t+"\n";
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new self().run();
    }
}
