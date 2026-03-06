import java.util.*;
import java.io.*;

public class partners{
    Map<String, Set<String>> airlines = new TreeMap<>();
    boolean found;
    ArrayList<String> checked = new ArrayList<>();
    String goal;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("partners2".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            airlines.put(f.nextLine(), new TreeSet<>());
        }
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            String name = f.next();
            String name2 = f.next();
            airlines.get(name).add(name2);
            airlines.get(name2).add(name);
        }
//        for(Map.Entry<String, Set<String>> entry: airlines.entrySet()){
//            System.out.println(entry);
//        }
//        System.out.println();
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            checked = new ArrayList<>();
            found = false;
            goal = f.next();
            String start = f.next();
            recur(start);
            System.out.println(found? "PARTNERS" : "No miles for you");
        }
        f.close();
    }
    void recur(String curr){
        if(found || checked.contains(curr)){
            return;
        }
        if(airlines.get(curr).contains(goal)){
            found=true;
            return;
        }
        for(String s : airlines.get(curr)){
            checked.add(curr);
            recur( s);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new partners().run();
    }
}
