import java.util.*;
import java.io.*;

public class Akash{

    public void run() throws FileNotFoundException {

        String s = "";
        for (int i = 2; i <= 20; i++) {
            s += i + " ";
        }
        System.out.println(s.trim());
        System.out.println("2 3 5 7 9 11 13 15 17 19");
        System.out.println("2 3 5 7 11 13 17 19");
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Akash().run();
    }
}
