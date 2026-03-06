import java.util.*;
import java.io.*;

public class ariel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ariel".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String[] arrivals = f.nextLine().split(" ");
            String[] departures = f.nextLine().split(" ");
            train[] trains = new train[departures.length];

            int minStart = Integer.MAX_VALUE;
            int maxEnd = Integer.MIN_VALUE;

            for (int i = 0; i < trains.length; i++) {
                String[] arrTimes = arrivals[i].split(":");
                int arrHour = Integer.parseInt(arrTimes[0]);
                int arrMin = Integer.parseInt(arrTimes[1]);
                String[] depTimes = departures[i].split(":");
                int depHour = Integer.parseInt(depTimes[0]);
                int depMin = Integer.parseInt(depTimes[1]);
                if(i>0 && arrHour<trains[i-1].start/60){
                    arrHour+=24;
                    }

                if(i>0 && depHour<trains[i-1].end/60 || arrHour > depHour)
                    depHour+=24;

                if(minStart> arrHour * 60 + arrMin)
                    minStart = arrHour * 60 + arrMin;
                if(maxEnd<depHour * 60 + depMin)
                    maxEnd = depHour * 60 + depMin;
                trains[i] = new train(arrHour * 60 + arrMin, depHour * 60 + depMin);
            }

//            System.out.println(minStart+" "+maxEnd);

//            for(train t : trains){
//                System.out.println(t);
//            }


            int maxTrains = 0;
            for(int i = minStart; i<=maxEnd; i+=5){
                int trainRunning = 0;
                String s = "";
                for(train t : trains){
                    if(t.start <= i && i < t.end){
                        trainRunning++;
                        s+=t.toString();
                    }
                }
                if(trainRunning>maxTrains) {
                    maxTrains = trainRunning;
                }
            }

            System.out.println(maxTrains);



        }
        f.close();
    }



    class train{
        int start;
        int end;
        public train(int start, int end){
            this.start = start;
            this.end = end;
        }
        public String toString(){
            return start/60+":"+start%60+" "+end/60+":"+end%60+" "+start+" "+end;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new ariel().run();
    }
}
