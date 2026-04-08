import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class carlos{
    class word implements Comparable<word>{
        String s;
        HashMap<Character, Integer> counts;
        public word(String s){
            this.s = s;
            counts=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        public int compareTo(word o){
            return s.compareTo(o.s);
        }
        public String toString(){
            return s;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("carlos".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int size = f.nextInt();
            ArrayList<ArrayList<word>> set = new ArrayList<>();
            boolean[] added = new boolean[size];
            word[] words = new word[size];
            String[] ln = f.next().split(",");
            for (int i = 0; i < ln.length; i++) {
                words[i] = new word(ln[i].trim());
            }

            for (int i = 0; i < size; i++) {
                if(added[i]){
                    continue;
                }
                ArrayList<word> curSet = new ArrayList<>();
                curSet.add(words[i]);
                added[i] = true;
                for (int j = i+1; j < size; j++) {
                    if(words[i].counts.equals(words[j].counts)){
                        curSet.add(words[j]);
                        added[j] = true;
                    }
                }
                if(!curSet.isEmpty()) {
                    set.add(curSet);
                }
            }
            for(ArrayList<word> curSet : set){
                Collections.sort(curSet);
            }
            Collections.sort(set, (ArrayList<word> o1, ArrayList<word> o2) -> o1.getFirst().compareTo(o2.getFirst()));
            String out = "";
            for(ArrayList<word> set1 : set){
                out += set1.toString().replace(" ", "") + ",";
            }
            System.out.println(out.substring(0, out.length()-1));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new carlos().run();
    }
}
