import java.util.*;
import java.io.*;
import java.awt.*;

public class testCaseGeneratorMonte{

    public void run() throws Exception {
        new PrintWriter("monteDooku.dat").close();
        new PrintWriter("monteDooku.out").close();
        BufferedWriter dat = new BufferedWriter(new FileWriter("monteDooku.dat"));
        BufferedWriter out = new BufferedWriter(new FileWriter("monteDooku.out"));
        Random rand = new Random();
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        System.out.println(times);
        dat.write(times+"\n");
        while (times-- > 0) {
            int T = rand.nextInt(0, 1000), M = rand.nextInt(0, 1000);
            dat.write(T+" "+M+"\n");
            System.out.println(T+" "+M);
            Troop[] troops = new Troop[T];
            int cnt = 0;
            ArrayList<Integer> indices = new ArrayList<>();
            loop:
            while(cnt<troops.length) {
                boolean clone = rand.nextBoolean();
                double x = rand.nextDouble(-1E3, 1E3), y = rand.nextDouble(-1E3, 1E3), r = rand.nextDouble(0, 1E3);
                Troop t = new Troop(x, y, r, clone);
                for(Troop tr : troops){
                    if(tr==null) break;
                    if(t.intersects(tr)){
                        continue loop;
                    }
                }
                if(!clone) indices.add(cnt);
                troops[cnt] = new Troop(x, y, r, clone);
                dat.write(clone?"C":"D");
                dat.write(String.format(" %.2f %.2f %.2f\n", x, y, r));
                System.out.println((clone?"C":"D")+String.format(" %.2f %.2f %.2f", x, y, r));
                cnt++;
            }
            System.out.println(indices);
            for(Integer i : indices){
                if(troops[i].clone) System.out.println("BROKEN "+i);
            }
            int eliminated = 0;
            cnt=0;
            while (cnt<M) {
                int ind = rand.nextInt(0, troops.length);
                if(!indices.contains(ind)){
                    continue;
                }
                double dx = rand.nextDouble(-100, 100) , dy = rand.nextDouble(-100, 100);
                dat.write(ind+" "+String.format("%.2f %.2f\n", dx, dy));
                System.out.println(ind+" "+String.format("%.2f %.2f", dx, dy));
                cnt++;
            }


        }
        dat.flush();
        dat.close();
        out.flush();
        out.close();
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

    public static void main(String[] args) throws Exception{
        new testCaseGeneratorMonte().run();
    }
}

