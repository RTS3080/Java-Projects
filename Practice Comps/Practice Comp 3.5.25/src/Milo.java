import java.util.*;
import java.io.*;

public class Milo{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("Milo".toLowerCase()+".dat"));

        HashMap<String, Integer> map = new HashMap<>() {{
           put("I", 1);
           put("X", 10);
           put("V", 5);
           put("L", 50);
           put("C", 100);
           put("M", 1000);
           put("D", 500);
        }};

        while(in.hasNext()) {
            String word = in.next().toUpperCase();
            int count = 0;
            for (int i = 0; i < word.length()-1; i++) {
                if(map.get(word.substring(i,i+1)) < map.get(word.substring(i+1,i+2))){
                    count -= map.get(word.substring(i,i+1));

                }
                else {
                    count += map.get(word.substring(i,i+1));
                }
            }
            count += map.get(word.substring(word.length()-1));
            System.out.println(count);

        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Milo().run();
    }
}
