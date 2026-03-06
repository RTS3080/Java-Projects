import java.util.*;
import java.io.*;

public class prob24{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        String x = f.nextLine(), y = f.nextLine(), z = f.nextLine();
        String last = f.nextLine();
        System.out.println(convert(x));
        System.out.println(convert(y));
        System.out.println(convert(z));
        System.out.println(reverse(last));
        f.close();
    }

    public String convert(String s){
        String r = "";
        for(int i = 0; i < s.length(); i++){
            int c  = s.charAt(i);
            r+= Integer.toString(Integer.parseInt(c+""),3)+".";
        }
        return  r.substring(0, r.length()-1);
    }


    public String reverse(String s){
        String[] a = s.split("\\s+");
        String r = "";
        for(String e : a){
            String[] ar = e.split("\\.");
            for (String string : ar) {
                r += ((char) Integer.parseInt(string, 3)) + "";
            }
            r+=" ";
        }
        return r.substring(0, r.length()-1);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new prob24().run();
    }
}
