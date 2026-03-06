import java.util.*;
import java.io.*;

public class spice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spice".toLowerCase()+".dat"));
        TreeMap<String, ArrayList<String>> subs = new TreeMap<>();
        TreeMap<String, ArrayList<String>> subsCopy = new TreeMap<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            String str = ln[0].trim();
            subs.put(str, new ArrayList<>());
            subsCopy.put(str, new ArrayList<>());

            for (int i = 1; i < ln.length; i++) {
                subs.get(str).add(ln[i]);
                subsCopy.get(str).add(ln[i]);
            }

        }
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String[] ln = f.nextLine().split(" ");
                String sub = ln[ln.length-1];
                String measure  = "";
                for (int i = 0; i < ln.length-1; i++) {
                    measure += ln[i]+" ";
                }

                if(subs.containsKey(sub)){
                    sub = subs.get(sub).removeFirst();
                }
                System.out.println(measure+sub);

            }
            System.out.println();
            for(String s : subs.keySet()){
                subs.put(s, new ArrayList<>(subsCopy.get(s)));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new spice().run();
    }
}
