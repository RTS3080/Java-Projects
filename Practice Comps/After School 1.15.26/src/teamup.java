import java.util.*;
import java.io.*;
import java.awt.*;

public class teamup{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("teamup".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while(cases-->0){
            double sSpeed = f.nextDouble();
            double sFight = f.nextDouble();
            double sGloat = f.nextDouble();

            double hSpeed = f.nextDouble();
            double hFight = f.nextDouble();
            double hGloat = f.nextDouble();

            double startX = f.nextDouble();
            double startY = f.nextDouble();

            int numVillains = f.nextInt();

            villains = new double[numVillains][3];
            for (int i = 0; i < numVillains; i++) {
                f.next();
                villains[i] = new double[]{f.nextDouble(), f.nextDouble(), f.nextDouble()};
            }

            double spiderT = getTime(sSpeed,sFight,sGloat,startX,startY);
            double torchT = getTime(hSpeed,hFight,hGloat,startX,startY);

            if (spiderT <= torchT) System.out.println("He's A Menace!!");
            else System.out.println("Get Torched.");
        }

        f.close();
    }

    double[][] villains;

    public double getTime(double speed, double fight, double gloat, double startX, double startY){
        double curX = startX;
        double curY = startY;
        double time = 0.0;

        for (int i = 0; i < villains.length; i++) {
            double dis = Math.hypot(curX - villains[i][0], curY - villains[i][1]);
            time += dis / speed;

            time += (villains[i][2] * fight) + gloat;

            curX = villains[i][0];
            curY = villains[i][1];
        }

        return time;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new teamup().run();
    }
}
