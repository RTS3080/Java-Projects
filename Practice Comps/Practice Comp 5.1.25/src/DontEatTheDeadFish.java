import java.util.*;
import java.io.*;
import java.awt.*;

public class DontEatTheDeadFish{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("F".toLowerCase()+".txt"));
        int cses = f.nextInt();
        for (int tst = 0; tst < cses; tst++) {
            System.out.print(f.nextInt()+" ");
            int n = f.nextInt();
            int m = f.nextInt();
            String let = f.next();
            String other = let.equals("A") ? "B" : "A";

            if (n % (m+1) != 0)
                System.out.println(let);
            else
                System.out.println(other);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new DontEatTheDeadFish().run();
    }
}

