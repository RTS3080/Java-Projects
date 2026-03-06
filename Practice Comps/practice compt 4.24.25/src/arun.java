import java.util.*;
import java.io.*;

public class arun{

    public void run() throws FileNotFoundException{
        String s = "STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST";
        String rev = "TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS";
        for (int i = 0; i < s.length()/3-1; i++) {
            System.out.println((s.charAt(i*3)+"").repeat(s.length()));
            System.out.println(s);
            System.out.println(rev);
        }
        System.out.println("S".repeat(s.length()));
        System.out.println(s);

    }



    public static void main(String[] args) throws FileNotFoundException{
        new arun().run();
    }
}
