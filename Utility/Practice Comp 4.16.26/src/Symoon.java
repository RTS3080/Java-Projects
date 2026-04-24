import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Symoon{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Symoon".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            double goal = f.nextLong();
            boolean d = recur(0, goal, 0, "");
            System.out.println(d ? "Mr.Aura" : "Legend of the past.");
        }
        f.close();
    }
    boolean recur(double val, double goal, int count, String stack){
        if(val == goal && count == 5){
            return true;
        }
        if(count > 5) return false;
        return recur(val + 212, goal, count + 1, stack+"+") || recur(val * 212, goal, count + 1, stack+"*") ||
                recur(val / 212, goal, count + 1, stack+"/") || recur(val - 212, goal, count + 1, stack+"-");

    }


    public static void main(String[] args) throws FileNotFoundException{
        new Symoon().run();
    }
}
