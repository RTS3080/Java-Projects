import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob14{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob14".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));

        while (f.hasNext()){
            String l = f.nextLine().trim();
            if (l.equals("END")) {
                break;
            }

            String[] words = l.split(" +");
            String res = "";

            for (String line : words) {
                String result = "";

                String chars = line.replaceAll("[^A-Za-z\\-']", "");
                String reversed = new StringBuilder(chars).reverse().toString();

                int idx = 0;
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) + "").matches("[A-Za-z\\-']")) {
                        result += reversed.charAt(idx++);
                    } else {
                        result += line.charAt(i);
                    }
                }

                res += " " + result;
            }

            System.out.println(res.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob14().run();
    }
}
