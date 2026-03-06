import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class characterCounter{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("characterCounter".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String ln = f.nextLine();
            System.out.println(ln);
            System.out.println("-".repeat(ln.length()));
            String[] words = ln.split(" ");
            ArrayList<Character> chars = new ArrayList<>();
            HashMap<Character, Integer> map=new HashMap<>();
            for (int i = 0; i < ln.length(); i++) {
                char c = ln.charAt(i);
                if(!map.containsKey(c)){
                    chars.add(c);
                }
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            System.out.println("CHARACTERS: "+ln.length());
            System.out.println("WORDS: "+words.length);
            Collections.sort(chars, (a, b) -> -map.get(a).compareTo(map.get(b)));
            for(Character c : chars){
                System.out.println(c+": "+map.get(c));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new characterCounter().run();
    }
}
