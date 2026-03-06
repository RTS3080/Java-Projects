import java.util.*;
import java.io.*;

public class prob02{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        String s = f.nextLine();
        String coll = "";
        for (int i = 1; i <= s.length(); i++) {
            if(i%3 !=0){
                System.out.print(s.substring(i-1, i));

            }
            else{
                coll+=s.substring(i-1, i);
            }
        }
        System.out.println();
        System.out.println(coll);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob02().run();
    }
}
