import java.util.*;
import java.io.*;

public class audrey{

    public void run() throws FileNotFoundException{
        String s = "UILCOMPSCI";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(".".repeat(i)+s.charAt(i)+
                    ".".repeat(s.length()-i-1)+s.charAt(i)+
                    ".".repeat(s.length()-i-1)+s.charAt(i)+".".repeat(i));
        }
        System.out.println(s+"*"+(new StringBuffer(s).reverse()));
        for (int i = s.length()-1; i >= 0; i--) {
            System.out.println(".".repeat(i)+s.charAt(i)+
                    ".".repeat(s.length()-i-1)+s.charAt(i)+
                    ".".repeat(s.length()-i-1)+s.charAt(i)+".".repeat(i));
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new audrey().run();
    }
}
