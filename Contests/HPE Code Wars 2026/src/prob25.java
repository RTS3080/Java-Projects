import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob25{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob25".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String orig = f.next(); f.nextLine();
        String str = f.nextLine().trim();
        String[] ln = str.split(" ");
        HashMap<Character, Integer> counts = new HashMap<>();
        ArrayList<Character> freq = new ArrayList<>();
        for(String s : ln){
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(!Character.isLetter(ch)){
                    continue;
                }
                ch = Character.toUpperCase(ch);
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);

                if(!freq.contains(ch))
                    freq.add(ch);
            }
        }
        Collections.sort(freq, (Character a, Character b) -> counts.get(b)-counts.get(a));
        String s = "";
        for(char c : freq){
            s += c;
        }

        String out = "";
//        System.out.println(freq);
//        System.out.println(orig);
//        System.out.println(s);
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isLetter(str.charAt(i)) || Character.isSpaceChar(str.charAt(i))){
                out+=str.charAt(i);
                continue;
            }
            char c = str.charAt(i);
            c = Character.toUpperCase(c);
//            System.out.print(c+" ");
            int ind = s.indexOf(c);
            char o = orig.charAt(ind);
            if(Character.isLowerCase(str.charAt(i))){
                out+=Character.toLowerCase(o);
            }
            else{
                out+=o;
            }
        }
        System.out.println(s);
        System.out.println(out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob25().run();
    }
}
