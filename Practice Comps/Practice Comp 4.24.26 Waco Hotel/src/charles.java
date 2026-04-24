import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class charles{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("charles".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();
        for(int times = 0; times < numTimes; times++){
            int n = f.nextInt();
            TreeSet<Integer> factors = new TreeSet<>();
            factors.add(n);
            factors.add(1);
            for (int i = 2; i < n/2; i++) {
                if(n%i == 0){
                    factors.add(i);
                    factors.add(n/i);
                }
            }
//            System.out.println(factors);
            int sum = 0;
            String out = "";
            for(int s : factors){
                sum+=s;
                out+=s+"+";
            }
            out = out.substring(0, out.length()-1);
            System.out.println(out+"="+sum );
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new charles().run();
    }
}
