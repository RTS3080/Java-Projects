import java.util.*;
import java.io.*;

public class cerebro{

    HashMap<String,ArrayList<String>> bob;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cerebro".toLowerCase()+".dat"));
        int k = f.nextInt();
        int p = f.nextInt();
        f.nextLine();
        bob = new HashMap<>();
        for (int i = 0; i < p; i++) {
            String a = f.next();
            String b = f.next();
            f.nextLine();
            bob.putIfAbsent(a,new ArrayList<>());
            bob.get(a).add(b);
        }
        for (int i = 0; i < k; i++) {
            String in = f.next();
            HashSet<String> vis = new HashSet<>();
            if (recur(in, "Xavier", vis)) {
                System.out.println("Mutant Located.");
            } else {
                System.out.println("Nowhere to be found.");
            }
        }
        f.close();
    }


    public boolean recur (String in, String cur,HashSet<String> vis){
        if (bob.get(cur).contains(in)){
            return true;
        }

        boolean res = false;
        ArrayList <String> names = bob.get(cur);
        for (int i = 0; i < names.size(); i++) {
            if (!vis.contains(names.get(i))){
                vis.add(names.get(i));
                res |= recur(in,names.get(i),vis);
                vis.remove(names.get(i));
            }
        } return res;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new cerebro().run();
    }
}
