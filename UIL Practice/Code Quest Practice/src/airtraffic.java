import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class airtraffic{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("1".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            boolean friendly = f.nextBoolean();
            int numDetections=f.nextInt();
            int minThreat = 0;
            String[] levels = new String[]{"NONE", "LOW", "MEDIUM", "HIGH"};

            for (int i = 3; i >= 1; i--) {
                if(numDetections >= i * 12){
                    minThreat = i;
                    break;
                }
            }

            int[] detections = new int[numDetections];
            for (int i = 0; i < numDetections; i++) {
                String[] str = f.next().split(":");
                int hours = Integer.parseInt(str[0]);
                int minutes = Integer.parseInt(str[1]);
                int time = hours * 60 + minutes;
                if(i != 0 && time < detections[i - 1]){
                    time += 24 * 60;
                }
                detections[i] = time;
            }
//            System.out.println(Arrays.toString(detections));

            int airspaceEntrances = 1;
            int currentContinuous = 1;
            int maxContinuous = 0;
            int p = 0;
            while(p < detections.length - 1){
                if(detections[p + 1] - detections[p] == 15){
                    currentContinuous++;
                }
                else{
                    airspaceEntrances++;
                    maxContinuous = Math.max(maxContinuous, currentContinuous);
                    currentContinuous = 1;
                }
                p++;
            }
            if(currentContinuous > 0){
                maxContinuous = Math.max(maxContinuous, currentContinuous);
            }

            for (int i = 3; i >= 1; i--) {
                if(maxContinuous >= i * 4){
                    minThreat = max(i, minThreat);
                    break;
                }
            }
//            System.out.println("Max Continuous: "+maxContinuous);
//            System.out.println(minThreat);

            if(airspaceEntrances >= 8){
                minThreat = 3;
            }
            else if(airspaceEntrances >= 4){
                minThreat = max(2, minThreat);
            }
//            System.out.println("Airspace Entrances: "+airspaceEntrances);
//            System.out.println(minThreat);

            if(friendly) minThreat = 0;
            System.out.println(levels[minThreat]);


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new airtraffic().run();
    }
}
