import java.util.*;
import java.io.*;
import java.awt.*;

public class monteDooku{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("monteDooku".toLowerCase()+".dat"));
        int times=f.nextInt();

        while(times-->0){
            int times2 = f.nextInt(), times3 = f.nextInt();
            Troop[] troops = new Troop[times2];
            for(int i = 0; i < times2; i++){
                boolean clone = f.next().trim().equals("C");
                double x = f.nextDouble(), y = f.nextDouble(), r = f.nextDouble();
                troops[i]=new Troop(x,y,r,clone);
            }
            int eliminated = 0;
            while(times3-->0){
                int ind = f.nextInt();
                double dx = f.nextDouble(), dy = f.nextDouble();
                Troop copy = troops[ind].copy(dx,dy);
                if(copy.clone) System.out.println("SOMETHING'S WRONG: "+ind);
                ArrayList<Integer> toRemove = new ArrayList<>();
                boolean isMoveable = true;
                for(int i =0; i < troops.length; i++){
                    if(i==ind) continue;
                    Troop t = troops[i];
                    if(copy.intersects(t)){
                        if(t.clone && t.active){
                            toRemove.add(i);
                        }
                        if(!t.clone){
                            isMoveable = false;
                        }
                    }
                }
                if(isMoveable){
                    for(int i : toRemove){
//                        if(troops[i].active) {
                            eliminated++;
                            troops[i].active = false;
//                        }
                    }
                    troops[ind].x+=dx;
                    troops[ind].y+=dy;
                }
            }
            System.out.println(eliminated+" Clones Eliminated");
            for(Troop t : troops){
                if(!t.clone){
                    System.out.printf("(%.3f, %.3f)\n", t.x, t.y);
                }
            }

        }
        f.close();
    }

    class Troop{
        double x;
        double y;
        double r;
        boolean clone;
        boolean active;
        public Troop(double x, double y, double r, boolean clone){
            this.x=x;
            this.y=y;
            this.r=r;
            this.clone=clone;
            active = true;
        }
        Troop copy(double dx, double dy){
            return new Troop(x+dx, y+dy, r, clone);
        }
        boolean intersects(Troop t){
            return Math.hypot(x-t.x, y-t.y)<=r+t.r;
        }
        public String toString(){
            return String.format("(%.3f %.3f) %.2f %s", x, y, r, clone?"Clone" :"Droid");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new monteDooku().run();
    }
}
