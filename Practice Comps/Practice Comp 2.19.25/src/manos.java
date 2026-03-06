import java.util.*;
import java.io.*;

public class manos{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("manos".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int one = f.nextInt();
            int two = f.nextInt();
//            if (one == 0 || two == 0) {
//                System.out.println("P1");
//                continue;
//            }

            if (one == 1 && two == 1) {
                System.out.println("P2");
                continue;
            }

            if (one == 1 || two == 1) {
                System.out.println("P1");
                continue;
            }

            if (one == 2 && two == 2) {
                System.out.println("P2");
                continue;
            }

            System.out.println("P1");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new manos().run();
    }
}
