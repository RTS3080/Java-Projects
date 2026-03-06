import java.util.*;
import java.io.*;

public class anagram{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int grams = 0;
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<Character, Integer> str1= new HashMap<>();
            HashMap<Character, Integer> str2= new HashMap<>();
            String s1 = f.next().trim();
            String s2 = f.next().trim();
            for (int i = 0; i < s1.length(); i++) {
                Character c = s1.charAt(i);
                str1.putIfAbsent(c, 0);
                str2.putIfAbsent(c, 0);
                str1.put(c, str1.get(c) + 1);
            }
            for (int i = 0; i < s2.length(); i++) {
                Character c = s2.charAt(i);
                str1.putIfAbsent(c, 0);
                str2.putIfAbsent(c, 0);
                str2.put(c, str2.get(c) + 1);
            }
//            System.out.println(str1);
//            System.out.println(str2);
            boolean good = true;
            if(s1.length()!=s2.length()){
                good = false;
            }
            for(Map.Entry<Character, Integer> entry: str1.entrySet()){
                if(str1.get(entry.getKey())!=str2.get(entry.getKey())){
                    good = false;
                }
            }
            if(good)
                grams++;
        }
        System.out.println(grams);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new anagram().run();
    }
}
