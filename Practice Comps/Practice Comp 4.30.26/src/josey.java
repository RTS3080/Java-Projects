import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class josey{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("josey".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            TreeSet<String> countries = new TreeSet<>();
            String[][] edges = new String[f.nextInt()][2];

            for (int i = 0; i < edges.length; i++) {
                String a = f.next();
                String b = f.next();
                countries.add(a);
                countries.add(b);
                edges[i] = new String[]{a, b};
            }

            countries.remove("OCEAN");

            for (int i = 0; i < 2; i++) {
                TreeSet<String> copy = new TreeSet<>(countries);
                for (String[] edge : edges) {
                    String u = edge[0];
                    String v = edge[1];

                    if (!countries.contains(u)) copy.remove(v);
                    if (!countries.contains(v)) copy.remove(u);
                }

                countries = copy;
            }

            System.out.println("Case #" + (times + 1) + ": " + countries.size());
            for (String country : countries) {
                System.out.println(country);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new josey().run();
    }
}
