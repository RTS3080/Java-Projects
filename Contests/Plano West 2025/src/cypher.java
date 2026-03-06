import java.util.*;
import java.io.*;

public class cypher{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        int count = 0;
        for (int i = 0; i < times; i++) {
            String s = f.nextLine();
            if(s.contains("0") && s.contains("1") && !s.matches("([01])(\\1).*") && !s.matches(".+([01])(\\1)")){count++;}
        }
        System.out.println(count+" "+(times-count));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cypher().run();
    }
}
