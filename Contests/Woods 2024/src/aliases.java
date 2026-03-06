import java.util.*;
import java.io.*;

public class aliases {

    public static void main(String[] args) throws Exception {
        new aliases().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("aliases.dat"));
        int cases = in.nextInt(); in.nextLine();

        for (int i = 0; i < cases; i++) {
            System.out.println(in.nextLine().replaceAll("[0-9]",""));
        }

    }
}