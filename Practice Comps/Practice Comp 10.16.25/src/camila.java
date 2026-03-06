import java.util.*;
import java.io.*;
import java.awt.*;

public class camila{

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("camila".toLowerCase() + ".dat"));
        while (f.hasNext()) {
            String s = f.next().toUpperCase();
//            System.out.println(s);
            String str = s.charAt(0) + "";

            for (int i =1 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if(getCode(c+"") == getCode(s.charAt(i-1)+"")) {
                    continue;
                }
                str+=getCode(c+"");
                if (str.length() >= 4) break;

            }
            if (str.length() < 4) {
                str += "0".repeat(4 - str.length());
            }
            System.out.printf("%s\n", str);
        }
        f.close();
    }
    String getCode(String s){
        if (s.matches("[BFPV]")) {
             return "1";
        }
        else if (s.matches("[CGJKQSXZ]")) {
             return "2";
        }
        else if (s.matches("[DT]")) {
             return "3";
        }
        else if (s.matches("[L]")){
             return "4";
        } else if (s.matches("[MN]")){
             return "5";
        } else if (s.matches("[R]")){
             return "6";
        }
        return "";
    }


    public static void main(String[] args) throws FileNotFoundException{
        new camila().run();
    }
}
