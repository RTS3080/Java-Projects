import java.util.*;
import java.io.*;

public class carol{
    public boolean checkPal(String str) {
        StringBuilder st = new StringBuilder(str);
        st.reverse();
        return st.toString().equals(str);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("carol".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            String tmp = f.nextLine().trim();
            String str = tmp.toLowerCase();
            int min = str.length();
            for (int i = str.length() - 1; i >= 1; i--) {
                if (checkPal(str.substring(0, i))) {
                    min = Math.min(min, str.length() - str.substring(0, i).length());
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if (checkPal(str.substring(i))) {
                    min = Math.min(min, str.length() - str.substring(i).length());
                }
            }

            System.out.print(min + " ");
            System.out.println("character(s) need to be added to convert " + tmp + " into a palindrome.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new carol().run();
    }
}
