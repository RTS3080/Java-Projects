import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Mine{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Mine".toLowerCase()+".dat"));
        HashMap<Character, Double> values = new HashMap<>();
        values.put('N', .35);
        values.put('P', 4.93);
        values.put('U', 2.32);
        values.put('C', .63);
        values.put('I', .86);
        values.put('S', 1.15);
        values.put('D', 0.);
        while(f.hasNext()){
            char[] ln = f.next().toCharArray();
            double val = 0;
            for(char c: ln){
                val+=values.get(c);
            }
            val -= .17 * ln.length;
            if(val < -1){
                System.out.println("Do Not Mine");
            }
            else if (val <= 5){
                System.out.println("Further Sampling");
            }
            else if(val > 5){
                System.out.println("Begin Mining");
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Mine().run();
    }
}
