import java.util.*;
import java.io.*;

public class milkMeasurement{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Measurement".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("Measurement".toLowerCase()+".out"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<change> changes = new ArrayList<>();
        TreeMap<String, Integer> cows = new TreeMap<>();
        cows.put("Mildrid", 7);
        cows.put("Elsie", 7);
        cows.put("Bessie", 7);

        while(times-->0){
            int day = f.nextInt();
            String name = f.next();
            String change = f.next();
            int c = 0;
            if(change.contains("+")){
                c = Integer.parseInt(change.substring(1));
            }
            else c = Integer.parseInt(change);
            changes.add(new change(day,name,c));
        }
        Collections.sort(changes);
        System.out.println(changes);
        int picChanges  =0;
        int max = -1;
        ArrayList<String> maxCows = new ArrayList<>();
        for(change c: changes) {
            cows.put(c.name,c.change+cows.get(c.name));
            for (Map.Entry e : cows.entrySet()) {
                System.out.println(e);
                if ((int) (e.getValue()) >= max) {
                    if (!maxCows.contains((String) e.getKey())) {
                        max = (int) (e.getValue());
                        maxCows.add((String) e.getKey());
                        System.out.println(e.getKey() + " " + e.getValue());
                    }
                }
            }
        }

        f.close();
    }
    class change implements Comparable<change>{
        public int day;
        public String name;
        public Integer change;
        change(int day, String cow, int change){
            this.day=day;
            this.name=cow;
            this.change=change;
        }

        public int compareTo(change o){
            return Integer.compare(this.day, o.day);
        }
        public String toString(){
            return day+" "+name+" "+change;
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new milkMeasurement().run();
    }
}
