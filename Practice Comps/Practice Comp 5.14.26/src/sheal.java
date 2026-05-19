import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sheal{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sheal".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            String test = f.next();
            int check = f.nextInt();
            strs = new TreeSet<>();
            recur(test, "");

            int ind = 0;
            for (String each:strs){
                ind++;
                if (ind == check){
                    System.out.println(each);
                    break;
                }
            }
        }

        f.close();
    }

    public void recur(String orig, String temp){
        if (orig.isEmpty()) return;
        for (int i = 0; i < orig.length(); i++){
            String chosen = orig.substring(0, i) + orig.substring(i+1);
            strs.add(temp + orig.charAt(i));
            recur(chosen, temp+orig.charAt(i));
        }
    }

    TreeSet<String> strs;

    public static void main(String[] args) throws FileNotFoundException{
        new sheal().run();
    }
}
