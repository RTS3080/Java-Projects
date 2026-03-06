import java.util.*;
import java.io.*;
import java.awt.*;

public class day{
    public String format(String str, int len) {
        int left = (len - str.length()) / 2;
        int right = (len - str.length() + 1) / 2;
        return "|" + " ".repeat(left) + str + " ".repeat(right) + "|";
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("day".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String name = f.nextLine().trim() + "!";
            int length = Math.max(7, name.length());

            System.out.println("-".repeat(length + 2));
            System.out.println(format("Welcome", length));
            System.out.println(format(name, length));
            System.out.println("|  " + "*".repeat(length - 4) + "  |");
            System.out.println("-".repeat(length + 2));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new day().run();
    }
}
