import java.util.*;
import java.io.*;
import java.awt.*;

public class RSVPs{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("RSVPs".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        int yesCount = 0, noCount=0;
        while(times-->0){
            f.next();
            int size = f.nextInt();
            String rsvp = f.next();
            if(rsvp.equals("Yes")){
                yesCount+=size;
            }
            else if(rsvp.equals("No")){
                noCount+=size;
            }
        }
        System.out.printf("%d %d %.2f%%\n", yesCount,noCount,(double)yesCount*100/(double)(yesCount+noCount));
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new RSVPs().run();
    }
}
