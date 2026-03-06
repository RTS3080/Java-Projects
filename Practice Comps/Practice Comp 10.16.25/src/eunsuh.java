import java.util.*;
import java.io.*;
import java.awt.*;

public class eunsuh{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("eunsuh".toLowerCase()+".dat"));
        while(f.hasNext()){
            String s = f.next();
            int count = 0;
            while(!s.isEmpty()) {
                int zero = s.lastIndexOf("0");
                if (zero != -1) {
                    s = s.substring(zero + 1);
                    count++;
                }
                if(s.isEmpty()) break;
                int biggest = -1;
                for (int i = 0; i < s.length(); i++) {
                    int a = Integer.parseInt(s.substring(i, i + 1));
                    if (a > biggest) {
                        biggest = a;
                    }
                }
                int ind = s.lastIndexOf(biggest + "");
                if (biggest % 2 == 0) {
                    biggest -= 2;
                } else biggest -= 1;
                s = s.substring(0, ind) + biggest + s.substring(ind + 1);
                count++;
//                System.out.println(s);

            }
            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new eunsuh().run();
    }
}
