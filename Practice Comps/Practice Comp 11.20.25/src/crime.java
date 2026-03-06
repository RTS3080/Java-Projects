import java.util.*;
import java.io.*;
import java.awt.*;

public class crime{

    public void run() throws FileNotFoundException{
        HashMap<String, String> counters = new HashMap<>();
        Scanner f= new Scanner(new File("crime".toLowerCase()+".dat"));
        Scanner dat = new Scanner(new File("crimeNames.dat"));
        while(dat.hasNext()){
            String[] ln = dat.nextLine().split("\\|");
            counters.put(ln[0], ln[1]);
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(counters.get(f.nextLine().trim()));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new crime().run();
    }
}
