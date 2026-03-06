import java.util.*;
import java.io.*;

public class sortSources{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dat.txt"));
        ArrayList<str> strs = new ArrayList<>();
        while(f.hasNext()){
            String s = f.nextLine().trim();
            strs.add(new str(s));
            f.nextLine();
        }
        Collections.sort(strs);
        for(str str : strs){
            System.out.println(str);
            System.out.println();
        }
        f.close();
    }

    class str implements Comparable<str>{
        String s;
        String comp;
        public str(String s){
            this.s = s;
            if(s.startsWith("\"")){
                comp = s.substring(1).toLowerCase();
            }
            else comp = s.toLowerCase();
        }
        public int compareTo(str o){
            return comp.compareTo(o.comp);
        }
        public String toString(){
            return s;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new sortSources().run();
    }
}
