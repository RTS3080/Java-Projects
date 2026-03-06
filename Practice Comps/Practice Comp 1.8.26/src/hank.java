import java.util.*;
import java.io.*;
import java.awt.*;

public class hank{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hank".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln=f.nextLine();
            boolean b = ln.matches("(\\w+://)?(\\w{2,}\\.)?\\w{2,}\\.\\w{2,}");
            System.out.println(b? "Validated" : "Hmm...can't reach this page");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hank().run();
    }
}
