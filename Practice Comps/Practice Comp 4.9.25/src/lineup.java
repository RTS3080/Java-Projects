import java.util.*;
import java.io.*;

public class lineup{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lineup".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abc = 1; abc<=times; abc++){
            System.out.println("Test Case #"+abc+":");
            int times2=f.nextInt(); f.nextLine();
            ArrayList<person> ppl = new ArrayList<>();
            while(times2-->0){
                String[] ln = f.nextLine().split(" ");
                ppl.add(new person(ln[0], ln[1], Integer.parseInt(ln[2])));
            }
            Collections.sort(ppl);
            for(person p: ppl){
                System.out.println(p);
            }
        }

        f.close();
    }
    class person implements Comparable<person>{
        String first;
        String last;
        int height;
        public person(String first, String last, int height){
            this.first=first;
            this.last=last;
            this.height=height;
        }
        public int compareTo(person p){
            if(this.height!=p.height){
                return this.height-p.height;
            }
            if(!last.equals(p.last)){
                return last.compareTo(p.last);
            }
            return first.compareTo(p.first);
        }
        public String toString(){
            return first+" "+last;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lineup().run();
    }
}
