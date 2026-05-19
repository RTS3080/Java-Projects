import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Isha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Isha".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        HashMap<String, Integer> zoneChange = new HashMap<>();
        zoneChange.put("SD", 0);
        zoneChange.put("DEN", 1);
        zoneChange.put("HOU", 2);
        zoneChange.put("CHA", 3);
        zoneChange.put("ORL", 3);
        Scanner sc = new Scanner("SD DEN 1:59\n" +
                "SD CHA 4:23\n" +
                "SD HOU 2:54\n" +
                "DEN HOU 2:05\n" +
                "HOU CHA 2:10\n" +
                "HOU ORL 2:01\n" +
                "CHA ORL 1:29\n" +
                "SD ORL 4:55\n" +
                "DEN CHA 4:15\n" +
                "DEN ORL 4:06");
        record edge(String city, int mins){};
        HashMap<String, ArrayList<edge>> graph = new HashMap<>();
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
            String[] time = sc.next().split(":");
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            int mins = Integer.parseInt(time[0] ) * 60 + Integer.parseInt(time[1]);
            graph.get(a).add(new edge(b, mins));
            graph.get(b).add(new edge(a, mins));
        }
        int numTimes=f.nextInt();f.nextLine();
//        System.out.println(graph);
        for(int times = 1; times <= numTimes; times++){
            String ln = f.nextLine();
            String startCopy = new String(ln);
            String[] arr = ln.split(" ");
//            System.out.println(Arrays.toString(arr));
            if (arr.length == 5) {
//                System.out.println("too big");
                if(arr[0].equals("San")){
                    ln = "SD" + ln.substring(9);
                }
                else{
                    ln = ln.substring(0, ln.length()-9)+"SD";
                }
            }
            ln = ln.replaceAll("Denver", "DEN");
            ln = ln.replaceAll("Houston", "HOU");
            ln = ln.replaceAll("Charlotte", "CHA");
            ln = ln.replaceAll("Orlando", "ORL");
//            System.out.println(ln);
            arr = ln.split(" ");
            String a = arr[0];
            String[] timeStart = arr[1].split(":");
            int startMins = Integer.parseInt(timeStart[0]) * 60 + Integer.parseInt(timeStart[1]);
            startMins %= 12*60;
            String b = arr[3];
            boolean morning = arr[2].equals("A.M.");
            if(!morning) startMins+= 12*60;
            ArrayList<edge> edges = graph.get(a);
            int t = startMins;
            for(edge e: edges){
                if(e.city.equals(b)){
                    t+=e.mins;
                }
            }
            t += (zoneChange.get(b)-zoneChange.get(a)) * 60;
            String mod = "A.M.";
            while(t >=12*60){
                if(mod.equals("P.M.")) mod = "A.M.";
                else mod = "P.M.";
                t-=12*60;
            }
            int hours = t/60;
            int mins = t%60;
            if(hours == 0) hours = 12;
//            System.out.println(startCopy+" "+hours+":"+mins+" "+mod);
            System.out.printf("%s %d:%02d %s\n", startCopy, hours, mins, mod);


         }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Isha().run();
    }
}
