import java.util.*;
import java.io.*;
import java.awt.*;

public class barisa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("barisa".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            String[] line = f.nextLine().split(",");
            Event[] events = new Event[line.length];

            for (int i = 0; i < line.length; i++) {
                String check = line[i];
                Scanner f2 = new Scanner(check);

                events[i] = new Event(f2.nextInt(), f2.nextInt(), f2.nextInt());
            }

            Arrays.sort(events);

            int[] dp = new int[line.length];

            for (int i = 0; i < line.length; i++) {
                dp[i] = events[i].value;

                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], dp[j]);

                    if (events[j].end <= events[i].start){
                        int check = dp[j] + events[i].value;
                        dp[i] = Math.max(dp[i], check);
                    }
                }
            }

            System.out.println(dp[line.length-1]);
        }
        f.close();
    }

    class Event implements Comparable<Event>{
        int start, end, value;
        public Event(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int compareTo(Event e){
            if (end == e.end){
                return value - e.value;
            }
            return end - e.end;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new barisa().run();
    }
}
