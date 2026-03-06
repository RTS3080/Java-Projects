import java.util.*;
import java.io.*;
import java.awt.*;

public class patrick{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("patrick".toLowerCase()+".dat"));

        while(f.hasNext()){
            String str = f.next();
            int n = f.nextInt();
            for (int i = 1; i < n; i++) {
                String next = "";
                int idx = 0;

                while (idx < str.length()) {
                    int count = 0;
                    char ch = str.charAt(idx);

                    while (idx < str.length() && str.charAt(idx) == ch) {
                        count++;
                        idx++;
                    }

                    next += count + "" + ch;
                }

                str = next;
            }

            System.out.println(str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new patrick().run();
    }
}
