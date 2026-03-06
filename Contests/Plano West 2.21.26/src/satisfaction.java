import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class satisfaction{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("satisfaction".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();

            boolean[] counted = new boolean[n + 1];

            for (int i = 2; i < n + 1; i++) {
                if (counted[i]) continue;
                for (int j = i * 2; j < n + 1; j++) {
                    counted[i] = true;
                    counted[j] = true;
                }
            }

            int count = 0;
            for (int i = 0; i < n + 1; i++) {
                if (counted[i]) count++;
            }
            System.out.println(count >> 1 << 1);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new satisfaction().run();
    }
}
