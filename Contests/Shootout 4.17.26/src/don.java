import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class don{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("don".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        Map<String, Integer> set = new TreeMap<>();
        for(int times = 0; times < numTimes; times++){
            String[] ln = f.nextLine().split(" ");
            set.putIfAbsent(ln[0], 0);
            String other = "";
            for (int i = 1; i < ln.length; i++) {
                other+=ln[i]+" ";
            }
            set.put(ln[0], set.get(ln[0])+1);
        }
        for(Map.Entry<String, Integer> entry : set.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new don().run();
    }
}
