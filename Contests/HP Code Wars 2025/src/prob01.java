import java.util.*;
import java.io.*;

public class prob01{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        System.out.println("It is by will alone I set my mind in motion.\n" +
                "It is by the juice of sapho that thoughts acquire speed,\n" +
                "the lips acquire stains.\n" +
                "The stains become a warning.\n" +
                "It is by will alone I set my mind in motion.\n" +
                "I'm going to let you in on a secret, "+f.nextLine().trim()+".\n" +
                "Things aren't going so well for the Harkonnen.\n" +
                "Are we to sit back and watch as the Emperor gives away Spice that is rightfully ours?\n" +
                "Cheer as the Atreides take our Imperial Basin?\n" +
                "Go. Take some men and mine everything.");
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new prob01().run();
    }
}
