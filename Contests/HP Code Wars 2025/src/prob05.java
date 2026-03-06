import java.util.*;
import java.io.*;

public class prob05{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int len = f.nextInt();
        while(f.hasNext()){
            String s = f.nextLine().trim();
            if(s.equals("000")){ break;}
            int idx = s.indexOf(".");
            if(idx == -1){
                System.out.println(s);
                continue;
            }
            String dec = s.substring(idx+1);
            dec = dec.substring(0,Math.min(dec.length(),len));

            System.out.println(s.substring(0,idx+1)+dec);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob05().run();
    }
}
