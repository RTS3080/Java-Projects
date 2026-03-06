import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class timeFlies{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        double[] conversions = {60, 60, 24};
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double originalTime = f.nextDouble();
            double time = originalTime;
            String startUnit = f.next();
            String endUnit = f.next();
            int startIndex = switch(startUnit){
                case "SECONDS" -> 0;
                case "MINUTES" -> 1;
                case "HOURS" -> 2;
                case "DAYS" -> 3;
                default -> -1;
            };
            int endIndex = switch(endUnit){
                case "SECONDS" -> 0;
                case "MINUTES" -> 1;
                case "HOURS" -> 2;
                case "DAYS" -> 3;
                default -> -1;
            };
//            System.out.println(startUnit + " " + endUnit + " " + startIndex + " " + endIndex);
            if(endIndex > startIndex){
                for (int i = startIndex; i < endIndex; i++) {
                    time /= conversions[i];
                }
            }
            else if(endIndex < startIndex){
                for(int i = startIndex-1; i>= endIndex; i--){
                    time*=conversions[i];
                }
            }
//            System.out.println(time);
            System.out.printf("%.0f %s->%.0f %s\n", originalTime, startUnit,  time, endUnit);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new timeFlies().run();
    }
}
