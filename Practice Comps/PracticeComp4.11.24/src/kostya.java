import java.util.*;
import java.io.*;

public class kostya{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kostya".toLowerCase()+".dat"));
        int times = f.nextInt();
        for (int i = 1; i <= times; i++) {
            double socks = f.nextDouble()*2;
            double spaces = f.nextDouble();
            double s2 = socks-spaces;
            double bad = socks-spaces*2;
//            if(s2<0 || bad<0)
//                bad=0;
            System.out.printf("Case #%d: %.4f\n",i,bad/s2);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kostya().run();
    }
}
