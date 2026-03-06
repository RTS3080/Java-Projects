import java.util.*;
import java.io.*;
import java.awt.*;

public class furnaceFuel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("furnaceFuel".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Stick", 1);
        map.put("Coal", 8);
        map.put("Lava Bucket", 100);
        map.put("CharCoal", 12);
        int sum = 0;
        while(times-->0){
            String s = f.nextLine().trim();
            sum+=map.getOrDefault(s, 0);
        }
        System.out.println(sum);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new furnaceFuel().run();
    }
}
