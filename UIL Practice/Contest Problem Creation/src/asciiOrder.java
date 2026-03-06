import java.util.*;
import java.io.*;
import java.awt.*;

public class asciiOrder{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("asciiOrder".toLowerCase()+".dat"));
        while(f.hasNext()){
            char[] chars = new char[f.nextInt()];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char)f.nextInt();
            }
            Arrays.sort(chars);
            System.out.println(chars);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new asciiOrder().run();
    }
}
