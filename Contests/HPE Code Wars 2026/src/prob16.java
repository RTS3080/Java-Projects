import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob16{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob16".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        int a= Integer.parseInt(f.next(),2);
        int b= Integer.parseInt(f.next(),2);
        int op= Integer.parseInt(f.next(),2);
        int carry  = 0;
        int out = 0;
        if(op == 0){
            out = a + b;

        }
        else if(op == 1){
            out = a|b;
        }
        else if (op == 2){
            out = a&b;
        }
        else if (op == 3){
            out = a^b;
        }
        if(out >=16){
            carry = 1;
        }
        out = out%16;
        String o = Integer.toString(out,2);
        o = ("0").repeat(4-o.length()) + o;
        System.out.println(o+" "+Integer.toString(carry, 2));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob16().run();
    }
}
