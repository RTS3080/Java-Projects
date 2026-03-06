import java.util.*;
import java.io.*;
import java.awt.*;

public class day{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("day".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0) {
            int M = f.nextInt();

            int[] starts = new int[M];
            for (int i = 0; i < M; i++) starts[i] = f.nextInt();

            int[] ends =  new int[M];
            for (int i = 0; i < M; i++) ends[i] = f.nextInt();

            int[] vals = new int[M];
            for (int i = 0; i < M; i++) vals[i] = f.nextInt();

            ArrayList<Event> events = new ArrayList<>();
            for (int i = 0; i < M; i++){
                events.add(new Event(starts[i], ends[i], vals[i]));
            }
            Collections.sort(events);

            long[] dp = new long[M];

            long result = 0;

            for (int i = 0; i < M; i++){
                long temp = events.get(i).vals;
                for (int before = 0; before < i; before++){
                    if (events.get(before).end <= events.get(i).start){
                        temp = Math.max(temp, dp[before] + events.get(i).vals);
                    }
                }
                dp[i] = temp;

                result = Math.max(dp[i], result);
            }

            System.out.println(result);
        }
        f.close();
    }

    class Event implements Comparable<Event>{
        int start, end, vals;
        public Event(int start, int end, int vals){
            this.start = start;
            this.end = end;
            this.vals = vals;
        }

        public int compareTo(Event e){
            return end - e.end;
        }

        public String toString(){
            return start + " " + end + " " + vals;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new day().run();
    }
}
