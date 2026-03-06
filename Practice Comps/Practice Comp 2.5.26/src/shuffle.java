import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class shuffle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shuffle".toLowerCase()+".dat"));
        while(f.hasNext()){
            String[] ln = f.nextLine().trim().split(" ");
            TreeSet<String> set = new TreeSet<>();
            for(String s : ln){
                set.add(s);
            }
            String str = "";
            for(String s : set){
                str+=s+" ";
            }
            System.out.println(str.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shuffle().run();
    }
}
