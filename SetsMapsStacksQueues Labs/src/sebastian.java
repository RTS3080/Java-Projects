import java.util.*;
import java.io.*;

public class sebastian{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sebastian".toLowerCase()+".dat"));
        TreeMap<Integer, String> ascii = new TreeMap<>();
        while(f.hasNext()){
            String a = f.next();
            int asc = 0;
            for(char c: a.toCharArray()){
                asc += c;
            }
            ascii.put(asc, a);
        }
        for(String s : ascii.values()){
            System.out.println(s);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new sebastian().run();
    }
}
