import java.util.*;
import java.io.*;
import java.awt.*;

public class explorer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("explorer".toLowerCase()+".dat"));
        while(f.hasNext()){
            f.nextLine();
            double r = f.nextDouble();
            double gas = f.nextDouble() * 5;
            double angle= f.nextDouble()%360; f.nextLine();
            angle = Math.abs(Math.min(angle, 360-angle));
            double dist = 4 * r * Math.PI * angle/360;
            int leftOver  = (int)((gas-dist)/5);
            if(gas>=dist){
                System.out.println("YES "+leftOver);
            }
            else{
                System.out.println("NO "+(int)gas);
            }
            f.nextLine();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new explorer().run();
    }
}
