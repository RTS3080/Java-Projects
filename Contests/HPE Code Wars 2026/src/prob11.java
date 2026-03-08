import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob11{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob11".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        double a = f.nextDouble();
        double b = f.nextDouble();
        double prob = f.nextDouble();
        String s= f.next();
        double strProb = 1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                strProb *= (1-a);
            }
            else if(s.charAt(i) == '0'){
                strProb*=(1-b);
            }
        }
        prob = 1-prob;
        strProb *=1000;
        int c = (int) strProb;
        String out = strProb < prob*1000 ? "reject" : "accept";
        System.out.printf("%.3f\n%s\n",c / 1000.,out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob11().run();
    }
}
