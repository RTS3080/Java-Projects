import java.util.*;
import java.io.*;

public class patric{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("patrick".toLowerCase()+".dat"));
        while(f.hasNext()){
            String a = f.next();
            int n = f.nextInt();
            for (int i = 0; i < n-1; i++) {
                String tmp = "";
                for (int j = 0; j < a.length(); j++) {
                    int c = 1;
                    while (j < a.length() - 1 && a.charAt(j) == a.charAt(j + 1)) {c++; j++;}
                    tmp += c + "" + a.charAt(j);

                } a = tmp;
//                System.out.println(tmp);
            }
            System.out.println(a);
//            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new patric().run();
    }
}
