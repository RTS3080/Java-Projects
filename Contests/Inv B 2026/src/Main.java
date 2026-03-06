import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().run();

    }
    void run() throws Exception{
        Scanner f= new Scanner(System.in);
        Vector a = new Vector(f.nextDouble(),f.nextDouble());
        Vector b = new Vector(f.nextDouble(),f.nextDouble());
        double thetaA = Math.atan2(a.y, a.x);
        double thetaB = Math.atan2(b.y, b.x);
        System.out.println(Math.toDegrees(thetaA) + ", " + Math.toDegrees(thetaB) +", "+ Math.toDegrees(thetaB-thetaA));
        System.out.println(Math.toDegrees(Math.atan2(a.y-b.y, a.x-b.x)));
        System.out.println(a.x*b.y - a.y*b.x);
    }
    class Vector{
        double x; double y;
        public Vector(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
