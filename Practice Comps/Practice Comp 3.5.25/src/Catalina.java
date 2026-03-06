import java.util.*;
import java.io.*;

public class Catalina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Catalina".toLowerCase()+".dat"));
        while(f.hasNext()){
            String ln = f.nextLine().trim();
            String s = "";
            for (int i = 0; i < ln.length(); i++) {
                if(Character.isUpperCase(ln.charAt(i))){
                    s += ln.charAt(i);
                }
            }
            System.out.println(s);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Catalina().run();
    }
}
