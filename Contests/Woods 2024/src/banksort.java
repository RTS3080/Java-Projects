import java.util.*;
import java.io.*;

public class banksort {

    public static void main(String[] args) throws Exception {
        new banksort().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("banksort.dat"));
        int cases = in.nextInt(); in.nextLine();

        for (int i = 0; i < cases ; i++) {
            Long pr = Long.valueOf(0);
            for (int j = 0; j < 10; j++) {
                int y = 0;
                try {
                    y=Integer.parseInt(in.next());
                }
                catch (Exception e){}

                pr+=Long.valueOf(y);
            }

            System.out.println(pr);
        }


    }
}