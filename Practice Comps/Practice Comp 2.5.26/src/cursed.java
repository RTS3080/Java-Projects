import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class cursed{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cursed".toLowerCase()+".dat"));
        String[] m = "january february march april may june july august september october november december".split(" ");
        HashMap<String, Integer> months = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            months.put(m[i], i+1);
        }

        while (f.hasNext()) {
            String[] ln = f.nextLine().trim().replaceAll(",", "").split(" ");
            String month = ln[0].toLowerCase();
            int day = Integer.parseInt(ln[1]);
            int year = Integer.parseInt(ln[2]);
            String date = String.format("%02d%02d%04d", months.get(month), day, year);
            boolean pal = !isPalindrome(date);
            System.out.println(date+": "+(pal ? "OK TO" : "DON'T")+" TRAVEL");
        }
        f.close();
    }
    boolean isPalindrome(String str){
        String rev = new StringBuilder(str).reverse().toString();
        return rev.equals(str);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new cursed().run();
    }
}
