import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class frances{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("frances".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        times:
        for(int times = 0; times < numTimes; times++){
            String[] required = f.nextLine().trim().split(",");
            String[] edges = f.nextLine().trim().split(",");
            String[] plan = f.nextLine().trim().split(",");
            f.nextLine();

            HashSet<String> planSet = new HashSet<>();

            for (String str : plan) {
                if (!planSet.add(str)) {
                    System.out.println("Degree plan #" + (times + 1) + " is illegal.");
                    continue times;
                }
            }

            for (String str : required) {
                if (!planSet.contains(str)) {
                    System.out.println("Degree plan #" + (times + 1) + " is illegal.");
                    continue times;
                }
            }

            HashMap<String, Integer> degree = new HashMap<>();
            HashMap<String, HashSet<String>> adj = new HashMap<>();

            for (String token : edges) {
                String[] edge = token.split("->");

                degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
                adj.putIfAbsent(edge[0], new HashSet<>());
                adj.get(edge[0]).add(edge[1]);
            }

            for (String cur : plan) {
                if (degree.getOrDefault(cur, 0) > 0) {
                    System.out.println("Degree plan #" + (times + 1) + " is illegal.");
                    continue times;
                }

                for (String next : adj.getOrDefault(cur, new HashSet<>())) {
                    degree.put(next, degree.get(next) - 1);
                }
            }

            System.out.println("Degree plan #" + (times + 1) + " is legal.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new frances().run();
    }
}
