import java.util.*;
import java.io.*;
import java.awt.*;

public class excellent{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("excellent".toLowerCase()+".dat"));
        int sp1cnt = f.nextInt();
        int sp2cnt = f.nextInt();
        f.nextLine();
        ArrayList<name> spread1 = new ArrayList<>();
        ArrayList<name> spread2 = new ArrayList<>();
        for (int i = 0; i < sp1cnt; i++) {
            String[] ln = f.nextLine().trim().split(" ");
            spread1.add(new name(ln[0].substring(0,ln[0].length()-1),ln[1]));
        }
        for (int i = 0; i < sp2cnt; i++) {
            String[] ln = f.nextLine().trim().split(" ");
            spread2.add(new name(ln[0].substring(0,ln[0].length()-1),ln[1]));
        }
        Collections.sort(spread1);
        Collections.sort(spread2);
        System.out.println("NAMES IN SPREADSHEET 1 THAT ARE NOT IN SPREADSHEET 2");
        for(name n : spread1){
            if(!contains(spread2,n)){
                System.out.println(n);
            }
        }
        System.out.println("NAMES IN SPREADSHEET 2 THAT ARE NOT IN SPREADSHEET 1");
        for(name n : spread2){
            if(!contains(spread1,n)){
                System.out.println(n);
            }
        }
        f.close();
    }
    boolean contains(ArrayList<name> spr, name na){
        for(name n : spr){
            if(n.last.equals(na.last) && n.first.equals(na.first)){
                return true;
            }
        }
        return false;
    }
    class name implements Comparable<name>{
        String first;
        String last;
        public name(String last, String first){
            this.first = first;
            this.last = last;
        }
        public int compareTo(name n){
            String s = last+first;
            String ns = n.last+n.first;
            return s.compareTo(ns);
        }
        public String toString(){
            return last+", "+first;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new excellent().run();
    }
}
