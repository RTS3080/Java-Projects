import java.util.*;
import java.io.*;

public class patryk{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("patryk".toLowerCase()+".dat"));
        TreeSet<num> nums = new TreeSet<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            nums.add(new num(f.nextInt()));
        }
        for(num num: nums){
            System.out.println(num);
        }
        f.close();
    }
    class num implements Comparable<num>{
        int num;
        int reverse;
        num(int n){
            num=n;
            StringBuilder s = new StringBuilder(n+"");
            s.reverse();
            reverse = Integer.parseInt(s.toString());
        }
        public int compareTo(num n){
            return Integer.compare(reverse,n.reverse);
        }
        public String toString(){
            return num+"";
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new patryk().run();
    }
}
