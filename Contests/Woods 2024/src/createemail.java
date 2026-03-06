import java.util.*;
import java.io.*;

public class createemail {

    public static void main(String[] args) throws Exception {
        new createemail().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("createemail.dat"));
        int cases = in.nextInt(); in.nextLine();

        for (int i = 0; i < cases; i++) {
            System.out.println(in.nextLine()+"@hotmail.com");
        }
    }
}