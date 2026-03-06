import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class sky{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("sky".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int cases = f.nextInt();
            double rapSpeed = f.nextDouble();
            double rapFuel = f.nextDouble();
            double rapPayload = f.nextDouble();
            double rapCosts = f.nextDouble();
            double raidSpeed = f.nextDouble();
            double raidFuel = f.nextDouble();
            double raidPayload = f.nextDouble();
            double raidCosts = f.nextDouble();
            for (int i = 0; i < cases; i++) {
                double dist = f.nextDouble();
                double payload = f.nextDouble();

                boolean rapOk = payload <= rapPayload;
                boolean raidOk = payload <= raidPayload;
                double rapTime = 3600 * dist / rapSpeed;
                double raidTime = 3600 * dist / raidSpeed;
                double rapFuelCost = dist * rapFuel;
                double raidFuelCost = dist * raidFuel;
                double rapScore = rapTime + rapFuelCost + rapCosts;
                double raidScore = raidTime + raidFuelCost + raidCosts;

                if(abs(rapScore - raidScore) < .01){
                    rapOk = dist*rapFuel < dist * raidFuel;
                    raidOk = !rapOk;

                }
                else{
                    if(rapOk && rapScore < raidScore){
                        raidOk = false;
                    }
                    if(raidOk && raidScore < raidFuel){
                        rapOk = false;
                    }
                }
//                System.out.println(rapScore+" "+raidScore);
//                System.out.println(rapOk+" "+raidOk);
                if(raidOk){
                    System.out.println("Sikorsky Raider");
                }
                else{
                    System.out.println("F-22 Raptor");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sky().run();
    }
}
