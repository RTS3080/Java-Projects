import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Conrad{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Conrad".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();

        for(int times = 0; times < numTimes; times++){
            boolean ok = true;
            char[] s = f.next().toUpperCase().toCharArray();
            int diff = 0;
            if(s.length<2) ok = false;
            diff = Math.abs(s[1]-s[0]);
            for (int i = 1; i < s.length-1; i++) {
                int d = Math.abs(s[i+1]-s[i]);
                if(d != diff){
                    ok = false;
                }
            }
            if(ok){
                System.out.println(s);
            }
            else{
                System.out.println("BAD!!!");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Conrad().run();
    }
}
