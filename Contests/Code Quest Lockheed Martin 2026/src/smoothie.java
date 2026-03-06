import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class smoothie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("smoothie".toLowerCase()+".in"));
        HashMap<String, Set<String>> map = new HashMap<>();
        String[] flavors = "strawberry swirl|banana burst|tropical tango|mango medly".split("\\|");
        String[] ingredients = "strawberry blueberry|banana kiwi orange|kiwi orange mango blueberry|mango strawberry blueberry|banana".split("\\|");
        for (int i = 0; i < flavors.length; i++) {
            String[] ing = ingredients[i].split(" ");
            TreeSet<String> ings = new TreeSet<>();
            for(String s : ing){
                ings.add(s);
            }
            map.put(flavors[i], ings);
        }
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String[] ings = f.nextLine().split("|");
            ArrayList<String> ng = new ArrayList<>();
            for(String s : ings){
                ng.add(s);
            }
            String flavor = f.nextLine().trim();
            Set<String> needed = map.get(flavor);

            boolean ok = true;
            for(String s : needed){
                ok &= ng.contains(s);
            }
            System.out.println(ok?"YES" : "NO");

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new smoothie().run();
    }
}
