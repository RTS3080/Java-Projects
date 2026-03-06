import java.util.*;
import java.io.*;

public class Mario{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mario".toLowerCase()+".dat"));
        int cses = f.nextInt();
        for (int tc = 0; tc < cses; tc++) {
            int flipLen = f.nextInt();
            String word = f.next();
            int len = word.length();
            if (flipLen > len)
                System.out.println("error");
            else if (flipLen > len / 2)
                System.out.println(new StringBuilder(word).reverse().toString());
            else{
                System.out.print(new StringBuilder(word.substring(len-flipLen)).reverse().toString());
                System.out.print(word.substring(flipLen,len-flipLen));
                System.out.println(new StringBuilder(word.substring(0,flipLen)).reverse().toString());
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Mario().run();
    }
}
