import java.util.*;
import java.io.*;

public class fuse {

    public static void main(String[] args) throws Exception {
        new fuse().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("fuse.dat"));
        int cases = in.nextInt(); in.nextLine();

        for (int i = 0; i < cases; i++) {
            System.out.println(in.nextLine().length()*2 + " seconds til it blows!");
        }
    }
}