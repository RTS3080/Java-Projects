import java.util.*;
import java.io.*;

public class Helena{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Helena".toLowerCase()+".dat"));
        int k =f.nextInt();
        f.nextLine();
        for (int x = 0; x < k; x++) {
            int size = f.nextInt();
            int loop = f.nextInt();
            f.nextLine();
            for (int u = 0; u < loop; u++) {
                String in  = f.nextLine();
                String res = "'";
                while (in.length() >= size*2) {
                    StringBuilder one = new StringBuilder(in.substring(0,size));
                    StringBuilder two = new StringBuilder(in.substring(size,size*2));
                    res+= two.reverse().toString()+one.reverse().toString();
                    in = in.substring(size*2);
                }
                StringBuilder one;
                StringBuilder two;
                if (in.length() %2==0) {
                    one = new StringBuilder(in.substring(0,in.length()/2));
                    two = new StringBuilder(in.substring(in.length()/2));
                }else {
                    one = new StringBuilder(in.substring(0,in.length()/2+1));
                    two = new StringBuilder(in.substring(in.length()/2+1));
                }
                res+= two.reverse().toString()+one.reverse().toString();
                System.out.println(res+"'");
            }
            System.out.println("=".repeat(25));

        }


        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Helena().run();
    }
}
