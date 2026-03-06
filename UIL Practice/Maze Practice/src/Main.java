import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws FileNotFoundException{

        System.out.println("FB".hashCode());
        System.out.println("Ea".hashCode());
        HashMap<String,Integer> map = new HashMap<>();
        map.put("FB", 3);
        map.put("Ea", 2);
        for(String s : map.keySet()){

            System.out.println(s+" "+s.hashCode());
        }
    }
}
