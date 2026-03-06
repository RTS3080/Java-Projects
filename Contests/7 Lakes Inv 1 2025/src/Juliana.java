import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Juliana{

    ArrayList<String> qual;
    ArrayList<String> vis;
    HashMap<String,ArrayList<String>> name;
    HashMap<String,ArrayList<String>> maj;
    HashMap<String,Integer> years;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Juliana".toLowerCase()+".dat"));
       int p = f.nextInt();
       int k = f.nextInt();
       f.nextLine();
       name = new HashMap<>();
        maj = new HashMap<>();
        years= new HashMap<>();
        for (int x = 0; x < k; x++) {
            String[] bob = f.nextLine().split(" ");
            String nam = bob[0]+" "+ bob[1].substring(0,bob[1].length()-1);
            int yrs = Integer.parseInt(bob[2]);
            String major = bob[3];
            String field = bob[4];
            name.putIfAbsent(nam, new ArrayList<>());
            if (bob.length > 5) {
                for (int i = 5; i <bob.length-1 ; i+=2) {
                    name.get(nam).add(bob[i]+" "+bob[i+1]);
                }
            }
            maj.putIfAbsent(nam, new ArrayList<>());
            maj.get(nam).add(major);
            maj.get(nam).add(field);
            years.put(nam,yrs);
        }


        for (int l = 0; l < p; l++) {
            qual= new ArrayList<>();
            vis = new ArrayList<>();
            String nam = f.next()+" "+f.next();
            int year = f.nextInt();
            String majo = f.next();

            recur(nam,majo,year);
            if (qual.contains(nam)){
                qual.remove(nam);
            }
            Collections.sort(qual);
            if (!qual.isEmpty()) {
                for (int i = 0; i < qual.size()-1; i++) {
                    System.out.print(qual.get(i)+", ");
                }
                System.out.println(qual.get(qual.size()-1));
            }else {
                System.out.println();
            }
        }



        f.close();
    }

    public void recur (String nam, String major, int yrs){
        if (!vis.contains(nam)){
            vis.add(nam);
            if ((maj.get(nam).get(0).equals(major)||maj.get(nam).get(1).equals(major))&&years.get(nam)>=yrs){
                qual.add(nam);
            }

            if (!name.get(nam).isEmpty()){
                for (int i = 0; i < name.get(nam).size(); i++) {
                    recur(name.get(nam).get(i), major, yrs);
                }
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Juliana().run();
    }
}
