import java.util.*;
import java.io.*;

public class agenda{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("agenda".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            int speed = f.nextInt();
            String next = f.nextLine();
            Time startTime = new Time(next);

            int totalMin = 0;

            while(true){
                String[] line = f.nextLine().trim().split(",");
                String[] separate = line[1].trim().split("\\s+");

                int temp = Integer.parseInt(separate[0]);
                if (separate[1].equals("MILES")){
                    totalMin += ((double)(temp)/speed)*60;
                }
                else{
                    totalMin += temp;
                }

                if (line[0].equals("GO HOME")){
                    break;
                }
            }
            startTime.addMin(totalMin);

            System.out.print("Joe will arrive home at ");
            startTime.print();

        }

        f.close();
    }
}

class Time{
    int hour;
    int minute;
    boolean AM;

    public Time(String use){
        String[] separate = use.trim().split("\\W+");
        hour = Integer.parseInt(separate[0]);
        minute = Integer.parseInt(separate[1]);
        if (separate[2].equals("AM")) AM = true;
        else AM = false;
    }

    public void addMin(double min){
        this.minute += min;
        hour += minute/60;
        this.minute %= 60;
    }

    public void print(){

        if (hour > 12){
            AM = ((hour/12)%2 == 0);
        }

//        hour %= 12;
        while(hour>12){
            hour-=12;
        }
        if (AM){
            System.out.printf("%02d:%02d AM%n", hour, minute);
        }
        else{
            System.out.printf("%02d:%02d PM%n", hour, minute);
        }
    }
}
