import java.util.*;
import java.io.*;
import java.awt.*;

public class Carolyn{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Carolyn".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char[] chars = f.nextLine().toCharArray();

            char start = chars[0];
            char end = chars[1];
            int i =0;
            int change = (int) Math.signum(end-start);
//            System.out.println(change);
            if(start == end) System.out.println(start);
            while(start!=end+change) {
                System.out.println(((char)(start)+"").repeat(i+1));
                start+= change;
                i++;
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Carolyn().run();
    }
}
