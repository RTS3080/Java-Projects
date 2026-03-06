import java.util.*;
import java.io.*;

public class values{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("values".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<words> w = new ArrayList<>();
        timeloop:
        while(times-->0){
            w.add(new words(f.nextLine()));
        }
        Collections.sort(w);
        for(words w1: w){
            System.out.println(w1);
        }
        f.close();
    }

    public class words implements Comparable<words>{
        String s;
        int sum;
        public words(String s){
            this.s=s;
            sum=0;
            for(char c:s.toCharArray()){
                if(c!=' ') {
                    sum += c - 'A'+1;
                }
            }
        }

        public int compareTo(words o){
            if(sum-o.sum!=0)return  sum-o.sum;
            return s.compareTo(o.s);
        }
        public String toString(){
            return sum+" "+s;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new values().run();
    }
}
