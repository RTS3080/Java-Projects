import java.util.*;
import java.io.*;

public class bruno{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bruno".toLowerCase()+".dat"));
        int count = 0;
        while(f.hasNext()){
            count+=f.nextLine().split("\\s+").length;
        }
        System.out.println(count);
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new bruno().run();
    }
}
