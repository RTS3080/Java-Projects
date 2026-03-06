import java.util.*;
import java.io.*;
import java.awt.*;

public class thing{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("thing".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine().trim();
            if (ln.equals("The Thing")) {
                System.out.println("Here's the Thing");
            }
            else if (ln.equals("Human Torch")){
                System.out.println("It's Clobberin' Time.");
            }
            else System.out.println("Not Now, I'm Working Over Here.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new thing().run();
    }
}
