import java.util.*;
import java.io.*;

public class schedule{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("schedule".toLowerCase()+".dat"));

        int times = f.nextInt();
        while (times-- > 0) {
            ArrayList<Interval> set = new ArrayList<>();
            int cases = f.nextInt();
            f.nextLine();
            for (int i = 0; i < cases; i++) {
                String tmp = f.nextLine().trim();
                Interval t = new Interval(tmp.substring(0, 8), tmp.substring(8));
                if (t.startTime < 180 || t.startTime > 1260) continue;
                set.add(new Interval(tmp.substring(0, 8), tmp.substring(8)));

            }
            Collections.sort(set);
            int best = 0;
            for (int i = 0; i < set.size() - 1; i++) {
                int count = 1;
                ArrayList<Interval> tmp = new ArrayList<>();
                tmp.add(set.get(i));
                for (int j = i + 1; j < set.size(); j++) {
                    if (set.get(i).checkBounds(set.get(j))) {
                        tmp.add(set.get(j));
                        count++;
                        i = j;
                    }
                }
                if (best < count) {
                    best = count;
                }
            }
            System.out.println(best);
        }

        f.close();
    }
}


class Interval implements Comparable<Interval>{
    int startTime;
    int endTime;

    public Interval(String start, String end){
        String[] sSeparate = start.trim().split("\\W+");
        String[] eSeparate = end.trim().split("\\W+");
//        System.out.println(Arrays.toString(sSeparate));

        startTime = Integer.parseInt(sSeparate[0])*60+Integer.parseInt(sSeparate[1]);
        endTime = Integer.parseInt(eSeparate[0])*60+Integer.parseInt(eSeparate[1]);

        if (sSeparate[2].equals("PM")) startTime += 12 * 60;
        if (eSeparate[2].equals("PM")) endTime += 12 * 60;
    }

    public boolean checkBounds(Interval other) {
        return (endTime < other.startTime);
    }

    public String toString() {
        return startTime / 60 + ":" + startTime % 60 + " " + endTime / 60 + ":" + endTime % 60;
    }

    @Override
    public int compareTo(Interval o) {
        if (startTime == o.startTime){
            return endTime-o.endTime;
        }

        else{
            return startTime-o.startTime;
        }
    }
}
