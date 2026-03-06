import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class TLA{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("TLA".toLowerCase()+".in"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String ln = f.nextLine();
//            ln = ln.replaceAll("[\\p{Punct}^\\-]", "");
            String[] words = ln.split(" |-");
            String out = "";
            for(String s : words){
                s = s.replaceAll("\\W", "");
                if(s.length()!=0){
                    out+=s.charAt(0);
                }
            }
            System.out.println(out.toUpperCase());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new TLA().run();
    }
}
