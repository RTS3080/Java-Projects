import java.util.*;
import java.io.*;
import java.awt.*;

public class banner{
    public String format(String str) {
        return str + " ".repeat(str.length() % 2);
    }

    public String center(String str, int l) {
        int spaces = l - str.length();
        spaces /= 2;
        return " ".repeat(spaces) + str + " ".repeat(spaces);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("banner".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String city = f.next();
            String name = f.next();

            city = format(city);
            name = format(name);
            String year = format(f.next());

            int length = Math.max(Math.max(Math.max(2, year.length()), name.length()), city.length());

            System.out.println("-".repeat(length + 2));
            System.out.println("|" + center(city, length) + "|");
            System.out.println("|" + center(name, length) + "|");
            System.out.println("|" + center("--", length) + "|");
            System.out.println("|" + center(year, length) + "|");
            System.out.println("-".repeat(length + 2));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new banner().run();
    }
}
