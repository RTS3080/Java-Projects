import java.util.*;
import java.io.*;
import java.awt.*;

public class MobMadness{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("MobMadness".toLowerCase()+".dat"));
        TreeMap<String, Integer> map = new TreeMap<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.nextLine().trim();
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s)+1);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new MobMadness().run();
    }
}
