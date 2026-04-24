import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class james{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("james".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int target = f.nextInt();
            ArrayList<Integer> fib = new ArrayList<>();
            fib.add(1);
            fib.add(1);
            while(fib.get(fib.size()-1) < target){
                fib.add(fib.get(fib.size()-1) + fib.get(fib.size()-2));
            }
            int a = 0;
            String picked = "";
            for(int i = fib.size()-1; i>=0; i--){
                if(a + fib.get(i) <= target){
                    a += fib.get(i);
                    picked = fib.get(i)+" "+picked;
                }

            }
            System.out.println(picked.trim());

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new james().run();
    }
}
