import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class nicholas{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("nicholas".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int numEvents = f.nextInt();
            f.nextLine();

            String[] line = f.nextLine().trim().split(",");
//            System.out.println(Arrays.toString(line));
            Event[] events = new Event[numEvents];
            for (int i = 0; i < line.length; i++){
                Scanner inF = new Scanner(line[i]);
                events[i] = new Event(inF.nextInt(), inF.nextInt(), inF.nextInt(), i+1);
            }
            Arrays.sort(events, (o1, o2) -> o1.finish-o2.finish);

            HashMap<Integer, Event> map = new HashMap<>();
            for (int i = 0; i < numEvents; i++){
                map.put(events[i].ind, events[i]);
            }

            ArrayList<Integer> finalList = new ArrayList<>();
            int finalRes = 0;

            int[] dp = new int[numEvents+1];
            ArrayList<Integer>[] dpList = new ArrayList[numEvents+1];
            for (int i = 1; i < dp.length; i++){
                int result = events[i-1].value;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(events[i-1].ind);

                for (int j = 1; j < i; j++){
                    if (events[j-1].finish <= events[i-1].start){
                        if (events[i-1].value + dp[j] > result){
                            result = events[i-1].value + dp[j];
                            list = new ArrayList<>(dpList[j]);
                            list.add(events[i-1].ind);
                        }
                    }
                }
                dp[i] = result;
                dpList[i] = list;

                if (result > finalRes) {
                    finalRes = result;
                    finalList = list;
                }
            }

//            System.out.println(finalList);

            ArrayList<Event> result = new ArrayList<>();
            for (int each : finalList) result.add(map.get(each));

            result.sort((o1, o2) -> o1.start - o2.start);
            StringBuilder str = new StringBuilder();
            for (Event each : result) str.append(each.ind).append(" ");
            System.out.println(str.toString().trim());
        }

        f.close();
    }

    class Event{
        int start, finish;
        int value;

        int ind;

        public Event(int start, int finish, int value, int ind){
            this.start = start;
            this.finish = finish;
            this.value = value;
            this.ind = ind;
        }

//        public String toString(){
//
//        }

//        public int compareTo(Event e){
//            return finish - e.finish;
//        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new nicholas().run();
    }
}
