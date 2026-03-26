import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class message{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("message".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();
        for(int times = 0; times < numTimes; times++){
            int len = f.nextInt(); f.nextLine();
            String[] ln = f.nextLine().replaceAll("\\p{Punct}", "").split(" ");
            ArrayList<String> out = new ArrayList<>();
            for(String s : ln){
                if(s.length() == len){
                    out.add(s);
                }
            }
            System.out.println(out.toString().replaceAll("[\\[\\],]", "").trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new message().run();
    }
}
