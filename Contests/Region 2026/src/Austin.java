import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Austin{
    class str implements Comparable<str>{
        int num;
        String s;
        public str(int num, String s){
            this.num = num;
            this.s = s;
        }
        public int compareTo(str o){
            return num - o.num;
        }
        public String toString(){
            return s;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Austin".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        ArrayList<str> arr = new ArrayList<>();
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int n = f.nextInt();
            String s = f.nextLine();
            s = s.substring(2, s.length()-1);
            arr.add(new str(n,s));
        }
        Collections.sort(arr);
        String res = "";
        for(str s : arr){
            res += s.toString();
        }
        System.out.println(res);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Austin().run();
    }
}
