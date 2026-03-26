import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class mostLeast{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mostLeast".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++) {
            HashMap<String, Integer> words = new HashMap<>();
            String[] ln = f.nextLine().replaceAll("\\p{Punct}", "").split(" ");
            ArrayList<String> set = new ArrayList<>();
            for (String s : ln) {
                words.put(s, words.getOrDefault(s, 0) + 1);
                if (!set.contains(s)) {
                    set.add(s);
                }
            }
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
                if (entry.getValue() < min) {
                    min = entry.getValue();
                }
            }
            ArrayList<String> maxWords = new ArrayList<>();
            ArrayList<String> minWords = new ArrayList<>();
            for (String s : set) {
                if (words.get(s) == max && !maxWords.contains(s)) {
                    maxWords.add(s);
                }
                if (words.get(s) == min && !minWords.contains(s)) {
                    minWords.add(s);
                }
            }
            Collections.sort(maxWords);
            Collections.sort(minWords);
            String outMax = max + " ";
            for (String s : maxWords) {
                outMax += s + " ";
            }
            String outMin = min + " ";
            for (String s : minWords) {
                outMin += s + " ";
            }
            System.out.println(outMax.trim());
            System.out.println(outMin.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mostLeast().run();
    }
}
