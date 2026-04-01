import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Charlie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Charlie".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String[] ln = f.next().split("");
            ArrayList<String> list = new ArrayList<>();
            for(String s : ln){
                list.add(s);
            }
            int change = f.nextInt();
            Collections.rotate(list, change);
            String out = "";
            for(String s : list){
                out+=s;
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Charlie().run();
    }
}
