import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class what {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("what".toLowerCase() + ".in"));
        int times = f.nextInt();
        f.nextLine();
        while (times--> 0) {
            System.out.println(f.nextLine());
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new what().run();
    }
}
