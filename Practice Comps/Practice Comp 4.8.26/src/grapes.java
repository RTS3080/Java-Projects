import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class grapes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("grapes".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        String[] str =
                ("  \\   \n" +
                " ()() \n" +
                "()()()\n" +
                " ()() \n" +
                "  ()  ").split("\\n");
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int t = f.nextInt();
            for(String s : str){
                System.out.println(s.repeat(t));
            }
        }
        f.close();
    }
    /*
     \
 ()()
()()()
 ()()
  ()
     */


    public static void main(String[] args) throws FileNotFoundException{
        new grapes().run();
    }
}
